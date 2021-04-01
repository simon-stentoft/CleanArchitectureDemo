package view;

import java.util.Observable;
import java.util.Observer;

import model.Model;

public class LowerCasePresenter extends Observable {

    private String presentableData;
    private Model model = new Model();

    public LowerCasePresenter() {
        observeModel(model);
        presentableData = getTransformedData(model.getData());
    }
    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                if (o instanceof Model) {
                    String data = ((Model) o).getData();
                    presentableData = getTransformedData(data);

                    LowerCasePresenter.super.setChanged();
                    LowerCasePresenter.super.notifyObservers();
                }
            }
        });
    }
        private String getTransformedData(String data) {
            return data.toLowerCase();
        }
        public String getPresentableData() {
        return presentableData;
        }
}
