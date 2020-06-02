package pl.edu.pwsztar.domain.dto.cure;

import java.io.Serializable;

public class ClientDoseReportDto implements Serializable {
    private String acceptedDose;
    private String date;

    public ClientDoseReportDto() {
    }

    public ClientDoseReportDto(Builder builder) {
        this.acceptedDose = builder.acceptedDose;
        this.date = builder.date;
    }

    public String getAcceptedDose() {
        return acceptedDose;
    }

    public String getDate() {
        return date;
    }

    public static final class Builder{
        private String acceptedDose;
        private String date;

        public Builder acceptedDose(String acceptedDose){
            this.acceptedDose = acceptedDose;
            return this;
        }

        public Builder date(String date){
            this.date = date;
            return this;
        }

        public ClientDoseReportDto build(){
            return new ClientDoseReportDto(this);
        }
    }
}
