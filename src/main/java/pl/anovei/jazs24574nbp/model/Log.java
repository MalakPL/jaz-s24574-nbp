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
    @Schema(name="Identyfikator komunikatu")
    public Long id;

    @Schema(name="Waluta")
    @Column(length = 3)
    public String currency;

    @Schema(name="Data początkowa")
    public String start_date;

    @Schema(name="Data końcowa")
    public String end_date;

    @Schema(name="Średni kurs z przedziału start_date i end_date")
    public double avg;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @Schema(name="Data wygenerowania komunikatu")
    public Date created;


}
