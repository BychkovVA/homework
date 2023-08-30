package atm.controller;



import atm.model.FormData;
import atm.service.ATM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormsController {

    private static  ATM atm = new ATM();

    /*наполняем банкомат*/
    static {
        atm.loadBanknotes(100, 5);
        atm.loadBanknotes(200, 10);
        atm.loadBanknotes(500, 3);
        atm.loadBanknotes(5000, 2);
    }


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
                return "atmTakeMoney";

            case "putMoney":
                return "atmPutMoney";

            case "seeBalance":
                message = atm.displayBalanceString();
                model.addAttribute("balance", message);
                return "atmBalance";

            case "changePinCode":
                return "atmChangePin";

            case "takeMoneyAmount":
                message = atm.withdrawAmount(formData.getAmount());
                model.addAttribute("message", message);
                return "message";

            case "putMoneyAmount":
                message = "Loaded money: " + formData.getAmount();
                model.addAttribute("message", message);
                return "message";

            case "change":
                message = "Pin changed";
                model.addAttribute("message", message);
                return "message";

            default:
                return "atm";
        }

    }

}