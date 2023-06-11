package av.uzmd.uzauto.useingretrofit;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ModelJson {
    @SerializedName("tarif_id")
    @Expose
    public String tarif_id;

    @SerializedName("tabel_raqam")
    @Expose
    public String tabel_raqam;

    @SerializedName("telefon_raqam")
    @Expose
    public String telefon_raqam;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("android_id")
    @Expose
    public String android_id;


    public String getandroid_id() {
        return android_id;
    }

    public void setandroid_id(String android_id) {
        this.android_id = android_id;
    }
    public String gettarif_id() {
        return tarif_id;
    }

    public void settarif_id(String android_id) {
        this.tarif_id = tarif_id;
    }

    public String gettabel_raqam() {
        return tabel_raqam;
    }

    public void settabel_raqam(String tabel_raqam) {
        this.tabel_raqam = tabel_raqam;
    }

    public String gettelefon_raqam() {
        return telefon_raqam;
    }

    public void settelefon_raqam(String telefon_raqam) {
        this.telefon_raqam = telefon_raqam;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }



}
