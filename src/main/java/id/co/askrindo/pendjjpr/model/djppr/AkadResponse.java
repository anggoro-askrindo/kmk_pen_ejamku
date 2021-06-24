package id.co.askrindo.pendjjpr.model.djppr;

import java.io.Serializable;

/**
 * Created by Anggoro Biandono on 13/11/2020.
 */
public class AkadResponse extends Akad implements Serializable {
    private static final long serialVersionUID = -4403108758854786056L;

    private Boolean aktif;

    public Boolean getAktif() {
        return aktif;
    }

    public void setAktif(Boolean aktif) {
        this.aktif = aktif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AkadResponse that = (AkadResponse) o;

        if (aktif != null ? !aktif.equals(that.aktif) : that.aktif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (aktif != null ? aktif.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AkadResponse{" +
                "aktif=" + aktif +
                '}';
    }
}
