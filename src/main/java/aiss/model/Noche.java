package aiss.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"fecha_suenyo",
"tipo_suenyo",
"calidad_suenyo",
"estado_animo",
"hora_in",
"hora_fin",
"duracion"
})
@Generated("jsonschema2pojo")
public class Noche {

@JsonProperty("id")
private String id;
@JsonProperty("fecha_suenyo")
private String fechaSuenyo;
@JsonProperty("tipo_suenyo")
private String tipoSuenyo;
@JsonProperty("calidad_suenyo")
private String calidadSuenyo;
@JsonProperty("estado_animo")
private String estadoAnimo;
@JsonProperty("hora_in")
private Integer horaIn;
@JsonProperty("hora_fin")
private Integer horaFin;
@JsonProperty("duracion")
private Integer duracion;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Noche() {}

public Noche(String fecha, String t_suen, String calidad, String animo, Integer HIn, Integer HFin) {
    this.fechaSuenyo=fecha;
    this.tipoSuenyo=t_suen;
    this.calidadSuenyo=calidad;
    this.estadoAnimo=animo;
    this.horaIn=HIn;
    this.horaFin=HFin;
     this.duracion=this.getDuracion();

}

public Noche(String id,String fecha, String t_suen, String calidad, String animo, Integer HIn, Integer HFin) {
    this.id=id;
    this.fechaSuenyo=fecha;
    this.tipoSuenyo=t_suen;
    this.calidadSuenyo=calidad;
    this.estadoAnimo=animo;
    this.horaIn=HIn;
    this.horaFin=HFin;
     this.duracion=this.getDuracion();

}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("fecha_suenyo")
public String getFechaSuenyo() {
return fechaSuenyo;
}

@JsonProperty("fecha_suenyo")
public void setFechaSuenyo(String fechaSuenyo) {
this.fechaSuenyo = fechaSuenyo;
}

@JsonProperty("tipo_suenyo")
public String getTipoSuenyo() {
return tipoSuenyo;
}

@JsonProperty("tipo_suenyo")
public void setTipoSuenyo(String tipoSuenyo) {
this.tipoSuenyo = tipoSuenyo;
}

@JsonProperty("calidad_suenyo")
public String getCalidadSuenyo() {
return calidadSuenyo;
}

@JsonProperty("calidad_suenyo")
public void setCalidadSuenyo(String calidadSuenyo) {
this.calidadSuenyo = calidadSuenyo;
}

@JsonProperty("estado_animo")
public String getEstadoAnimo() {
return estadoAnimo;
}

@JsonProperty("estado_animo")
public void setEstadoAnimo(String estadoAnimo) {
this.estadoAnimo = estadoAnimo;
}

@JsonProperty("hora_in")
public Integer getHoraIn() {
return horaIn;
}

@JsonProperty("hora_in")
public void setHoraIn(Integer horaIn) {
this.horaIn = horaIn;
}

@JsonProperty("hora_fin")
public Integer getHoraFin() {
return horaFin;
}

@JsonProperty("hora_fin")
public void setHoraFin(Integer horaFin) {
this.horaFin = horaFin;
}

@JsonProperty("duracion")
public Integer getDuracion() {
return duracion;
}

@JsonProperty("duracion")
public void setDuracion(Integer duracion) {
this.duracion = duracion;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}