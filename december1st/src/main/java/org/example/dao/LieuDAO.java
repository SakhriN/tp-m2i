package org.example.dao;

import org.example.Lieu;

import java.sql.Statement;
import java.util.List;

public interface LieuDAO {

    void ajouterLieu(Lieu lieu);
    void mettreAJourLieu(Lieu lieu);
    void supprimerLieu(int idLieu);
    Lieu obtenirLieuParId(int idLieu);
    List<Lieu> obtenirTousLesLieux();
}
