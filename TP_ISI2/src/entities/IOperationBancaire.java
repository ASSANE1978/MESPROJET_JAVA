package entities;

import java.util.List;

public interface IOperationBancaire  {
    public List<OperationBancaire> creation();
    public void Affiche(List<OperationBancaire> liste);
}
