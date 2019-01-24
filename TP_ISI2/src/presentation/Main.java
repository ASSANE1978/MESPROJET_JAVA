package presentation;

import entities.IOperationBancaire;
import entities.OperationBancaire;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args)
    {


        IOperationBancaire iop = new IOperationBancaire() {

            @Override
            public List<OperationBancaire> creation() {
                List<OperationBancaire> liste = new ArrayList<OperationBancaire>();
                Scanner scan = new Scanner(System.in);
                String rep = null;
                do{

                    OperationBancaire op = new OperationBancaire();
                    System.out.println("Entrer l'ID ");
                    int id = Integer.parseInt(scan.nextLine());
                    op.setId(id);

                    System.out.println("Entrer le libelle ");
                    String lib = scan.nextLine();
                    op.setLib(lib);

                    System.out.println("Entrer le montant ");
                    double montant = Double.parseDouble(scan.nextLine());
                    op.setMontant(montant);

                    System.out.println("Entre la date :dd/MM/yyyy ");
                    String date = scan.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

                    try {

                        op.setDate(sdf.parse(date));

                    }catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    liste.add(op);
                    System.out.println("Voulez vous continuer !!!");
                    rep = scan.nextLine();
                }while (rep.equalsIgnoreCase("oui"));

                return liste;
            }

            @Override

            public void Affiche(List<OperationBancaire> liste) {

                for(OperationBancaire op:liste){
                    System.out.println("IDENTIFIANT :" + op.getId());
                    System.out.println("LIBELLE :" + op.getLib());
                    System.out.println("MONTANT :" + op.getMontant());
                    System.out.println("DATE :" + op.getDate());

                }


            }


        };

        List<OperationBancaire> liste = iop.creation();
        iop.Affiche(liste);

    }

}
