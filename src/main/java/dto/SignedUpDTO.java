/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.SignedUp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class SignedUpDTO {
    
    private long id;
    private boolean payed;

    public SignedUpDTO() {
    }

    public SignedUpDTO(SignedUp signedUp) {
        this.payed = signedUp.isPayed();
        this.id = signedUp.getId();
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
    
//    public static List<SignedUpDTO> convertSignedUpListToSignUpsDTO(List<SignedUp> signUps){
//        List<SignedUpDTO> signedUpsDTO = new ArrayList<>();
//        for (SignedUp signedUp : signUps) {
//            signedUpsDTO.add(new SignedUpDTO(signedUp));
//        }
//        return signedUpsDTO;
//    } 
    
    
}
