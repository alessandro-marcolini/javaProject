package it.univpm.marcolini.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"url",
"place_type",
"name",
"full_name",
"country_code",
"country",
"centroid",
"bounding_box",
"attributes"
})
public class Record2 {

@JsonProperty("id")
public String id;
@JsonProperty("url")
public String url;
@JsonProperty("place_type")
public String placeType;
@JsonProperty("name")
public String name;
@JsonProperty("full_name")
public String fullName;
@JsonProperty("country_code")
public String countryCode;
@JsonProperty("country")
public String country;
@JsonProperty("centroid")
public List<Double> centroid = null;
@JsonProperty("bounding_box")
public BoundingBox boundingBox;
@JsonProperty("attributes")
public Attributes attributes;

public String toString() {
	return this.fullName;
}


}