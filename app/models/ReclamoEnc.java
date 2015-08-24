package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReclamoEnc {
	
	@Id
	@GeneratedValue
    public Long id;

    public String ClienteNombre;
    public int ClienteNumero;
    public int NumeroFactura;
    public Date FechaEntrega;
    public String TipoReclamo;
    public String UnidadMedida;
    public String LocalizacionOrigen;
    public String LocalizacionDestino;
    public String TipoContenedor;
    public String Carrier;

}
