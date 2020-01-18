package com.perscholas.nov2019.philly.capstone.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller    // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with / (after Application path)
public class  Controller {

    private Integer ticketBuyerId = -1;
    private Integer ticketSellerId, eventId;

    @Autowired // This means to get the bean called eventRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private EventRepository eventRepository;

    @Autowired // This means to get the bean called ticketBuyerRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private TicketBuyerRepository ticketBuyerRepository;

    @Autowired // This means to get the bean called ticketSellerRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private TicketSellerRepository ticketSellerRepository;

    @Autowired // This means to get the bean called ticketRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private TicketRepository ticketRepository;

    @Autowired // This means to get the bean called printableTicketRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private PrintableTicketRepository printableTicketRepository;

    private EventService eventService = new EventService();
    private BuyerService buyerService = new BuyerService();
    private SellerService sellerService = new SellerService();

    //search for events

    /*************************************************************************************************************************************************************************************************/
    @GetMapping(path = "/")
    public String setUpForm(Model model) {
        model.addAttribute("event", new Event());
        return "index";
    }

    @PostMapping(path = "/search_result")
    public String searchEvents(Event event, Model model) {

        List<Event> events = eventRepository.findEvents(event.getTitleofevent(), event.getPlaceofevent(), event.getDescription(), event.getStartdate(), event.getEnddate(), event.getLocaltimeofshow());

        if (eventService.isThere(event.getTitleofevent(), events)) {
            model.addAttribute("events", events);
            if (ticketBuyerId == -1)
                return "search_result";
            else
                return "search_result-loggedin";
        } else
            return "index";
    }
    /******************************************************************************************************************************************************************************************************/

    //register a buyer

    /****************************************************************************************************************************************************************************************/

    @GetMapping(path = "/register-buyer")
    public String setUpRegistrationForBuyer(Model model) {
        model.addAttribute("ticketbuyer", new TicketBuyer());
        return "register-buyer";
    }

    @PostMapping(path = "/register-buyer")
    public String registerBuyer(@ModelAttribute("ticketbuyer") TicketBuyer ticketBuyer) {

        List<TicketBuyer> lt = ticketBuyerRepository.findBuyers();

        if (buyerService.isThere(ticketBuyer.getEmail(), lt))
            return "error/register-buyer";

        String hashedPwd = buyerService.hashPassword(ticketBuyer.getPassword());

        try {
            ticketBuyerRepository.registerBuyer(ticketBuyer.getFirstname(), ticketBuyer.getLastname(), ticketBuyer.getAddress(), ticketBuyer.getEmail(), ticketBuyer.getPhone(), hashedPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "login-buyer";
    }

    @GetMapping(path = "/error/register-buyer")
    public String setupRegisterAgainBuyer(Model model) {
        model.addAttribute("ticketbuyer", new TicketBuyer());
        return "error/register-buyer";
    }

    @PostMapping(path = "/error/register-buyer")
    public String registerAgainBuyer(@ModelAttribute("ticketbuyer") TicketBuyer ticketBuyer) {

        List<TicketBuyer> lt = ticketBuyerRepository.findBuyers();

        if (buyerService.isThere(ticketBuyer.getEmail(), lt))
            return "error/register-buyer";

        String hashedPwd = buyerService.hashPassword(ticketBuyer.getPassword());

        try {
            ticketBuyerRepository.registerBuyer(ticketBuyer.getFirstname(), ticketBuyer.getLastname(), ticketBuyer.getAddress(), ticketBuyer.getEmail(), ticketBuyer.getPhone(), hashedPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "login-buyer";
    }
    /*******************************************************************************************************************************************************************************************/

    // A ticket buyer logs in.

    /***********************************************************************************************************************/
    @GetMapping(path = "/login-buyer")
    public String setUpLoginForBuyer(Model model) {
        model.addAttribute("ticketbuyer", new TicketBuyer());
        return "login-buyer";
    }

    @PostMapping(path = "/login-buyer")
    public String loginBuyer(@ModelAttribute("ticketbuyer") TicketBuyer ticketBuyer, @ModelAttribute("event") Event event) {
        List<TicketBuyer> lt = ticketBuyerRepository.findBuyers();

        if (buyerService.isThere(ticketBuyer.getEmail(), ticketBuyer.getPassword(), lt)) {
            ticketBuyerId = ticketBuyerRepository.findBuyerId(ticketBuyer.getEmail());
            return "index-loggedin";
        }

        return "error/login-buyer";
    }

    @GetMapping(path = "/error/login-buyer")
    public String setUpLoginAgainBuyer(Model model) {
        model.addAttribute("ticketbuyer", new TicketBuyer());
        return "login-buyer";
    }

    @PostMapping(path = "/error/login-buyer")
    public String loginAgainBuyer(@ModelAttribute("ticketbuyer") TicketBuyer ticketBuyer, @ModelAttribute("event") Event event) {
        List<TicketBuyer> lt = ticketBuyerRepository.findBuyers();

        if (buyerService.isThere(ticketBuyer.getEmail(), ticketBuyer.getPassword(), lt)) {
            ticketBuyerId = ticketBuyer.getId();
            return "index-loggedin";
        }

        return "error/login-buyer";
    }
    /***************************************************************************************************************************/

    //A seller registers.

    /****************************************************************************************************************************************************************************************************************************************************************************************/

    @GetMapping(path = "/register-seller")
    public String setUpRegistrationForSeller(Model model) {
        model.addAttribute("ticketseller", new TicketSeller());
        return "register-seller";
    }

    @PostMapping(path = "/register-seller")
    public String registerSeller(@ModelAttribute("ticketseller") TicketSeller ticketSeller) {
        List<TicketSeller> lt = ticketSellerRepository.findSellers();

        if (sellerService.isThere(ticketSeller.getOrgname(), lt))
            return "error/register-seller";

        String hashedPwd = sellerService.hashPassword(ticketSeller.getPassword());

        try {
            ticketSellerRepository.registerSeller(ticketSeller.getOrgname(), ticketSeller.getOrgaddress(), ticketSeller.getWebaddress(), ticketSeller.getContactfirstname(), ticketSeller.getContactlastname(), ticketSeller.getContactemail(), ticketSeller.getContactphone(), hashedPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "login-seller";
    }

    @GetMapping(path = "/error/register-seller")
    public String setUpRegistrationAgainSeller(Model model) {
        model.addAttribute("ticketseller", new TicketSeller());
        return "error/register-seller";
    }

    @PostMapping(path = "/error/register-seller")
    public String registerAgainSeller(@ModelAttribute("ticketseller") TicketSeller ticketSeller) {
        List<TicketSeller> lt = ticketSellerRepository.findSellers();

        if (sellerService.isThere(ticketSeller.getOrgname(), lt))
            return "error/register-seller";

        String hashedPwd = sellerService.hashPassword(ticketSeller.getPassword());

        try {
            ticketSellerRepository.registerSeller(ticketSeller.getOrgname(), ticketSeller.getOrgaddress(), ticketSeller.getWebaddress(), ticketSeller.getContactfirstname(), ticketSeller.getContactlastname(), ticketSeller.getContactemail(), ticketSeller.getContactphone(), hashedPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "login-seller";
    }
    /***************************************************************************************************************************************************************************************************************************************************************************************/

    //A seller logs in.

    /*****************************************************************************************************************************************/
    @GetMapping(path = "/login-seller")
    public String setUpLoginForSeller(Model model) {
        model.addAttribute("ticketseller", new TicketSeller());
        return "login-seller";
    }

    @PostMapping(path = "/login-seller")
    public String loginSeller(@ModelAttribute("ticketseller") TicketSeller ticketSeller, @ModelAttribute("event") Event event) {
        List<TicketSeller> lt = ticketSellerRepository.findSellers();

        if (sellerService.isThere(ticketSeller.getOrgname(), ticketSeller.getPassword(), lt))
            return "index";

        return "error/login-seller";
    }

    @GetMapping(path = "/error/login-seller")
    public String setUpLoginAgainSeller(Model model) {
        model.addAttribute("ticketseller", new TicketSeller());
        return "error/login-seller";
    }

    @PostMapping(path = "/error_login-seller")
    public String loginAgainSeller(@ModelAttribute("ticketseller") TicketSeller ticketSeller, @ModelAttribute("event") Event event) {
        List<TicketSeller> lt = ticketSellerRepository.findSellers();

        if (sellerService.isThere(ticketSeller.getOrgname(), ticketSeller.getPassword(), lt))
            return "index";

        return "error/login-seller";
    }
    /******************************************************************************************************************************************/

    //A ticket seller uploads an event.

    /********************************************************************************************************************************************************************************************************/
    @GetMapping(path = "/upload_event")
    public String uploadEvent(Model model) {
        model.addAttribute("event", new Event());
        return "upload_event";
    }

    @PostMapping(path = "/upload_event")
    public String handleUpload(@ModelAttribute("event") Event event) {

        try {
            eventRepository.insertEvent(event.getTicketsellerid(), event.getTitleofevent(), event.getPlaceofevent(), event.getDescription(), event.getStartdate(), event.getEnddate(), event.getLocaltimeofshow(), event.getPriceofticket(), event.getNumberoftickets());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }
    /*********************************************************************************************************************************************************************************************************************************************************************/

    //A ticket buyer buys a ticket

    /*****************************************************************************************************************************************************************/
    @PostMapping(path = "/buy_result")
    public String buyResult(@RequestParam("eventid") Integer eventId, @ModelAttribute("ticketbuyer") TicketBuyer ticketBuyer, @ModelAttribute("event") Event event) {

        if (ticketBuyerId == -1)
            return "login-buyer";

        if (ticketBuyerId != -1) {
            Integer ticketSellerId = eventRepository.findSellerId(eventId);
            ticketRepository.insertTicket(ticketBuyerId, ticketSellerId, eventId);
        }

        return "index-success";
    }
    /******************************************************************************************************************************************************************/

    // A buyer logs out.
    /***********************************/
    @GetMapping(path = "/userlogout")
    public String logOutBuyer() {
        ticketBuyerId = -1;
        return "userlogout";
    }
    /*********************************/

    //Buyers visit their "account" page
    /********************************************************************************/
    @GetMapping(path = "/buyer-account")
    public String accountBuyer(Model model) {
        TicketBuyer ticketBuyer = ticketBuyerRepository.findBuyerById(ticketBuyerId);
        List<PrintableTicket> lpt = printableTicketRepository.findPrintableTicketsByBuyerId(ticketBuyerId);
        model.addAttribute("ticketbuyer", ticketBuyer);
        model.addAttribute("printabletickets", lpt);
        return "buyer-account";
    }
    /********************************************************************************/

    //Buyers edit their accounts
    /*********************************************************************************/
    @GetMapping(path = "/edit-buyer")
    public String editBuyer(Model model) {

        model.addAttribute("ticketbuyer", new TicketBuyer());
        return "edit-buyer";
    }

    @PostMapping(path = "/buyer-account")
    public String updateBuyer(Model model, TicketBuyer ticketBuyer) {

        if (!buyerService.isEmpty(ticketBuyer, ticketBuyerId, ticketBuyerRepository))
            ticketBuyer.setPassword(buyerService.hashPassword(ticketBuyer.getPassword()));

        ticketBuyerRepository.update(ticketBuyer.getFirstname(), ticketBuyer.getLastname(), ticketBuyer.getAddress(), ticketBuyer.getEmail(), ticketBuyer.getPhone(), ticketBuyer.getPassword(), ticketBuyerId);
        TicketBuyer tb = ticketBuyerRepository.findBuyerById(ticketBuyerId);

        model.addAttribute("ticketbuyer", tb);

        return "buyer-account";
    }
    /*************************************************************************************************************************************************************************************************************/
}
