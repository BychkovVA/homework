package atm.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
@Log4j2
public class ATM implements CashReceiving, CashGiving {
    private Map<Integer, Integer> banknotes;

    public ATM() {
        banknotes = new TreeMap<>();
    }

    public void loadBanknotes(int denomination, int quantity) {
        if (banknotes.containsKey(denomination)) {
            int currentQuantity = banknotes.get(denomination);
            banknotes.put(denomination, currentQuantity + quantity);
        } else {
            banknotes.put(denomination, quantity);
        }
    }


    public String withdrawAmount(int amount) {
        Map<Integer, Integer> withdrawalBanknotes = new TreeMap<>(Comparator.reverseOrder());
        withdrawalBanknotes.putAll(banknotes);
        Map<Integer, Integer> selectedBanknotes = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int denomination : withdrawalBanknotes.keySet()) {
            int quantity = withdrawalBanknotes.get(denomination);
            int notesNeeded = amount / denomination;

            if (notesNeeded > 0) {
                int notesToDispense = Math.min(quantity, notesNeeded);
                selectedBanknotes.put(denomination, notesToDispense);
                amount -= notesToDispense * denomination;
            }
        }

        if (amount == 0) {
            for (int denomination : selectedBanknotes.keySet()) {
                int quantity = selectedBanknotes.get(denomination);
                result.append("Dispensing ").append(quantity).append(" notes of ₽").append(denomination).append("\n");
                banknotes.put(denomination, banknotes.get(denomination) - quantity);
            }
        } else {
            result.append("Unable to dispense the requested amount.\n");
        }

        return result.toString();
    }

    public void displayBalance() {
        System.out.println("Current balance:");
        for (int denomination : banknotes.keySet()) {
            log.info("₽" + denomination + ": " + banknotes.get(denomination));
        }
    }

    public String displayBalanceString() {
        String result = "Current balance:";
        for (int denomination : banknotes.keySet()) {
            result += "₽" + denomination + ": " + banknotes.get(denomination);
        }
        return result;
    }
}
