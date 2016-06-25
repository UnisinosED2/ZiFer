

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
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "v1",
    "v2",
    "deslocamento"
})
public class Properties {

    @JsonProperty("v1")
    private Integer v1;
    @JsonProperty("v2")
    private Integer v2;
    @JsonProperty("deslocamento")
    private String deslocamento;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The v1
     */
    @JsonProperty("v1")
    public Integer getV1() {
        return v1;
    }

    /**
     * 
     * @param v1
     *     The v1
     */
    @JsonProperty("v1")
    public void setV1(Integer v1) {
        this.v1 = v1;
    }

    /**
     * 
     * @return
     *     The v2
     */
    @JsonProperty("v2")
    public Integer getV2() {
        return v2;
    }

    /**
     * 
     * @param v2
     *     The v2
     */
    @JsonProperty("v2")
    public void setV2(Integer v2) {
        this.v2 = v2;
    }

    /**
     * 
     * @return
     *     The deslocamento
     */
    @JsonProperty("deslocamento")
    public String getDeslocamento() {
        return deslocamento;
    }

    /**
     * 
     * @param deslocamento
     *     The deslocamento
     */
    @JsonProperty("deslocamento")
    public void setDeslocamento(String deslocamento) {
        this.deslocamento = deslocamento;
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
