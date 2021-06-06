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
"fecha_in",
"fecha_fin",
"noches"
})
@Generated("jsonschema2pojo")
public class Intervalo {

@JsonProperty("id")
private String id;
@JsonProperty("fecha_in")
private String fechaIn;
@JsonProperty("fecha_fin")
private String fechaFin;
@JsonProperty("noches")
private Object noches;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Intervalo() {}

public Intervalo(String fecha_in, String fecha_fin) {
    this.fechaIn = fecha_in;
    this.fechaFin = fecha_fin;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("fecha_in")
public String getFechaIn() {
return fechaIn;
}

@JsonProperty("fecha_in")
public void setFechaIn(String fechaIn) {
this.fechaIn = fechaIn;
}

@JsonProperty("fecha_fin")
public String getFechaFin() {
return fechaFin;
}

@JsonProperty("fecha_fin")
public void setFechaFin(String fechaFin) {
this.fechaFin = fechaFin;
}

@JsonProperty("noches")
public Object getNoches() {
return noches;
}

@JsonProperty("noches")
public void setNoches(Object noches) {
this.noches = noches;
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
