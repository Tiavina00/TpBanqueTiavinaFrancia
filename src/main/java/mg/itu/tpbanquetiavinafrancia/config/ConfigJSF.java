/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquetiavinafrancia.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.transaction.Transactional;
import mg.itu.tpbanquetiavinafrancia.entity.CompteBancaire;
import mg.itu.tpbanquetiavinafrancia.service.GestionnaireCompte;

/**
 *
 * @author randr
 */
@ApplicationScoped
@FacesConfig
public class ConfigJSF {
    
    @Inject
    private GestionnaireCompte gestionnairecompte;

    @Transactional
    public void init(
            @Observes
            @Initialized(ApplicationScoped.class) ServletContext context) {
        if (gestionnairecompte.nbComptes() == 0) {
            gestionnairecompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionnairecompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionnairecompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionnairecompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }
    }
}
