package com.tts.weatherapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Request {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zip_id")
    private Long id;

    private String zipCode;

    public Request(){

    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Request [id=" + id + ", zipCode=" + zipCode + "]";
    }

    

    
    
}
