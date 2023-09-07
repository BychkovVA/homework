package atm.controller;



import atm.model.FormData;
import atm.service.ATM;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class FormsController {

    private static  ATM atm;

    @Autowired
    public FormsController(ATM atm) {
        this.atm = atm;
    }

    /*наполняем банкомат*/
    @PostConstruct
    public void init() {
        atm.loadBanknotes(100, 5);
        atm.loadBanknotes(200, 10);
        atm.loadBanknotes(500, 3);
        atm.loadBanknotes(5000, 2);
    }

    private static final String ATM_TAKE_MONEY_FORM = "atmTakeMoney";
    private static final String ATM_PUT_MONEY_FORM = "atmPutMoney";
    private static final String ATM_BALANCE_FORM = "atmBalance";
    private static final String ATM_CHANGE_PIN_FORM = "atmChangePin";
    private static final String MESSAGE_FORM = "message";
    private static final String ATM_FORM = "atm";

    @GetMapping("/forms")
    public String getFormsPage(Model model) {
        return "forms";
    }

    @GetMapping("/atm")
    public String getAtmPage(Model model) {
        return "atm";
    }

    @PostMapping("/submit")
    public String handleFormSubmit(@ModelAttribute FormData formData, String action, Model model) {

        String message;

        switch (action) {
            case "takeMoney":
                return ATM_TAKE_MONEY_FORM;

            case "putMoney":
                return ATM_PUT_MONEY_FORM;

            case "seeBalance":
                message = atm.displayBalanceString();
                model.addAttribute("balance", message);
                return ATM_BALANCE_FORM;

            case "changePinCode":
                return ATM_CHANGE_PIN_FORM;

            case "takeMoneyAmount":
                message = atm.withdrawAmount(formData.getAmount());
                model.addAttribute("message", message);
                return MESSAGE_FORM;

            case "putMoneyAmount":
                message = "Loaded money: " + formData.getAmount();
                model.addAttribute("message", message);
                return MESSAGE_FORM;

            case "change":
                message = "Pin changed";
                model.addAttribute("message", message);
                return MESSAGE_FORM;

            default:
                return ATM_FORM;
        }

    }

}