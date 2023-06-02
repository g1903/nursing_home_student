/*Wie implementiere ich eine Speicherfrist, die  im Hintergrund das Speicherdatum abfragt und nach Ablauf von 10 Jahren den entsprechenden Datensatz löscht */
package model;
import datastorage.TreatmentDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpeicherManager {
    private List<TreatmentDAO> speicherliste;
    private static final int MAX_ANZAHL_OBJEKTE = 10;

    public SpeicherManager() {
        speicherliste = new ArrayList<>();
    }

    public void addTreatmentEntry(Treatment treatment, Patient patient) {
        if (speicherliste.size() < MAX_ANZAHL_OBJEKTE) {
            TreatmentDAO treatmentDAO = new TreatmentDAO(treatment, patient);
            speicherliste.add(treatmentDAO);
        } else {
            System.out.println("Maximale Anzahl von Einträgen erreicht.");
        }
    }

    public void ueberpruefeSpeicherfrist() {
        Iterator<TreatmentDAO> iterator = speicherliste.iterator();
        LocalDate currentDate = LocalDate.now();

        while (iterator.hasNext()) {
            TreatmentDAO treatmentDAO = iterator.next();
            LocalDate speicherdatum = treatmentDAO.getSpeicherdatum();

            if (speicherdatum.plusYears(10).isBefore(currentDate)) {
                iterator.remove();
                System.out.println("Ein Datensatz wurde aufgrund der Speicherfrist gelöscht.");
            }
        }
    }
}