package pl.anovei.jazs24574nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

//Każdorazowe wykonanie zapytania ma zapisać
// w bazie danych następujące informacje:
// id (automatycznie przypisywane),
// walutę dla jakiej zostało wykonane zapytanie,
// datę rozpoczynającą przedział,
// datę kończącą przedział,
// jaki został wyliczony kurs,
// data oraz godzina zapytania.
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    @Column(length = 3)
    public String currency;


    public String start_date;


    public String end_date;


    public double avg;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    public Date created;


}
