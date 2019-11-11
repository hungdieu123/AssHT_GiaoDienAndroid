package vn.com.assignmentht.model;

public class LoaiChi {
    String loaichi;
    int idchi;

    public LoaiChi(String loaichi, int idchi) {
        this.loaichi = loaichi;
        this.idchi = idchi;
    }

    public String getLoaichi() {
        return loaichi;
    }

    public void setLoaichi(String loaichi) {
        this.loaichi = loaichi;
    }

    public int getIdchi() {
        return idchi;
    }

    public void setIdchi(int idchi) {
        this.idchi = idchi;
    }
}
