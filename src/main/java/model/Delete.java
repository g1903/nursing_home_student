package model;

import datastorage.DAOimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;




public class Delete extends DAOimp<Nursing> {
    private boolean lockP;
    private Connection conn;
    private String delete;

    public Delete(Treatment treatment, Patient patient) {
        super(treatment, patient);
    }


    public void NursingDAO(Connection conn, boolean lockP, String delete) {
        this.lockP = lockP;
        this.conn = conn;
        this.delete = delete;
    }

    public boolean lockP() {
        return lockP;
    }

    public Connection conn() {
        return conn;
    }

    public String delete() {
        return delete;
    }

    // ...

    public void deleteNursing(long nursingId) throws SQLException {
        // Überprüfe, ob Behandlungen existieren, die jünger als 10 Jahre sind
        boolean behandlungenJuengerAls10Jahre = checkBehandlungenJuengerAls10Jahre(nursingId);

        if (behandlungenJuengerAls10Jahre) {
            // Wenn Behandlungen existieren, die jünger als 10 Jahre sind, Pflegekraft sperren
            lockNursing(nursingId);
        } else {
            // Wenn keine Behandlungen existieren, die jünger als 10 Jahre sind, Pflegekraft löschen
            deleteNursing(nursingId);
        }
    }

    private void lockNursing(long nursingId) {
    }

    private boolean checkBehandlungenJuengerAls10Jahre(long nursingId) throws SQLException {
        // Aktuelles Datum minus 10 Jahre
        LocalDate zehnJahreZurueck = LocalDate.now().minusYears(10);

        String sql = "SELECT COUNT(*) FROM behandlung WHERE nursing_Id = ? AND behandlungsdatum > ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, nursingId);
            statement.setDate(2, java.sql.Date.valueOf(zehnJahreZurueck));

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int anzahlBehandlungen = resultSet.getInt(1);
                    return anzahlBehandlungen > 0;
                }
            }
        }
        return false;
    }

    @Override
    protected String getCreateStatementString(Nursing nursing) {
        return null;
    }

    @Override
    protected String getReadByIDStatementString(long key) {
        return null;
    }

    @Override
    protected Nursing getInstanceFromResultSet(ResultSet set, boolean Treatment) throws SQLException {
        return null;
    }

    @Override
    protected String getReadAllStatementString() {
        return null;
    }

    @Override
    protected ArrayList<Nursing> getListFromResultSet(ResultSet set) throws SQLException {
        return null;
    }

    @Override
    protected String getUpdateStatementString(Nursing nursing) {
        return null;
    }

    @Override
    protected String getDeleteStatementString(long key) {
        return null;
    }

    public boolean getLockP() {
        return lockP;
    }

    public void setLockP(boolean lockP) {
        this.lockP = lockP;
    }

    public String toString() {
        return "Delete" + "\nlockP: " + this.lockP() +
                "\nConnection: " + this.conn() +
                "\ndelete: " + this.delete() +
                "\n";
    }
}