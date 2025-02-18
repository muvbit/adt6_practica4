package es.muvment.model.dto;

public class ResumenDTO {
    private Long confirmadas;
    private Long noConfirmadas;

    public ResumenDTO(Long confirmadas, Long noConfirmadas) {
        this.confirmadas = confirmadas;
        this.noConfirmadas = noConfirmadas;
    }

    public Long getConfirmadas() {
        return confirmadas;
    }

    public void setConfirmadas(Long confirmadas) {
        this.confirmadas = confirmadas;
    }

    public Long getNoConfirmadas() {
        return noConfirmadas;
    }

    public void setNoConfirmadas(Long noConfirmadas) {
        this.noConfirmadas = noConfirmadas;
    }
}
