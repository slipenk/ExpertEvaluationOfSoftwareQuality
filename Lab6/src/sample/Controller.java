package sample;


import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import sample.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Controller implements Initializable {

    @FXML TableView<ValidityTableData> ValidityTable;
    @FXML TableColumn CriteriaNumber;
    @FXML TableColumn CriteriaName;
    @FXML TableColumn IndustryExpert;
    @FXML TableColumn UsabilityExpert;
    @FXML TableColumn ProgrammingExpert;
    @FXML TableColumn UsersExpert;


    @FXML TableView UsersMarksTable;
    @FXML TableColumn u1;
    @FXML TableColumn u2;
    @FXML TableColumn u3;
    @FXML TableColumn u4;
    @FXML TableColumn u5;
    @FXML TableColumn u6;
    @FXML TableColumn u7;
    @FXML TableColumn u8;
    @FXML TableColumn u9;
    @FXML TableColumn u10;
    @FXML TableColumn u11;
    @FXML TableColumn u12;
    @FXML TableColumn u13;
    @FXML TableColumn u14;
    @FXML TableColumn u15;
    @FXML TableColumn u16;
    @FXML TableColumn u17;
    @FXML TableColumn u18;
    @FXML TableColumn u19;
    @FXML TableColumn u20;


    @FXML TableView<ExpertsMarksData> ExpertsMarksTable;
    @FXML TableColumn сriteriaColumn;
    @FXML TableColumn IndustryExpertColumn;
    @FXML TableColumn UsabilityExpertColumn;
    @FXML TableColumn ProgrammingExpertColumn;
    @FXML TableColumn UsersExpertColumn;


    @FXML TableView<QCoefficientTableData> qCoefficientTable;
    @FXML TableColumn expertTypeColumn;
    @FXML TableColumn absoluteValueColumn;
    @FXML TableColumn relativeValueColumn;


    @FXML TableView<ComplexIndicatorsTableData>complexIndicatorsTable;
    @FXML TableColumn evaluationCriteriaColumn;
    @FXML TableColumn industryExpertsMarkColumn;
    @FXML TableColumn usabilityExpertsMarkColumn;
    @FXML TableColumn programmingExpertsMarkColumn;
    @FXML TableColumn usersMarkColumn;
    @FXML TableColumn avgMarksSumColumn;
    @FXML TableColumn avgMarksXiColumn;


    @FXML WebView industryWebView;
    @FXML WebView usabilityWebView;
    @FXML WebView programmingWebView;
    @FXML WebView usersWebView;
    @FXML WebView generalWebView;
    @FXML WebView avarageWebView;


    @FXML Label industrySquareLabel;
    @FXML Label usabilitySquareLabel;
    @FXML Label programmingSquareLabel;
    @FXML Label usersSquareLabel;
    @FXML Label generalSquareLabel;
    @FXML Label avarageSquareLabel;


    private void initializeWebView(){
        WebEngine industryWebEngine = industryWebView.getEngine();
        WebEngine usabilityWebEngine = usabilityWebView.getEngine();
        WebEngine programmingWebEngine = programmingWebView.getEngine();
        WebEngine usersWebEngine = usersWebView.getEngine();
        WebEngine generalWebEngine = generalWebView.getEngine();
        WebEngine avarageWebEngine = avarageWebView.getEngine();
        industryWebEngine.load(getClass().getResource("/graphic.html").toString());
        usabilityWebEngine.load(getClass().getResource("/graphic.html").toString());
        programmingWebEngine.load(getClass().getResource("/graphic.html").toString());
        usersWebEngine.load(getClass().getResource("/graphic.html").toString());
        generalWebEngine.load(getClass().getResource("/graphic.html").toString());
        avarageWebEngine.load(getClass().getResource("/graphic.html").toString());
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeWebView();
    }


    List<Double> getAColumn(List<Double> lengths,List<Double> degrees){
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            results.add(lengths.get(i) * Math.sin(degrees.get(i)));
        }
        return results;
    }

    List<Double> getBColumn(List<Double> lengths,List<Double> degrees){
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            results.add(lengths.get(i) * Math.cos(degrees.get(i)));
        }
        return results;
    }

    private List<Double> getFirstsTrianglesSquare(List<Double> aColumn,List<Double> bColumn){
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            int j = i + 1;
            if(j > 9){
                results.add(aColumn.get(j - 1) * bColumn.get(0));
                continue;
            }
            results.add(aColumn.get(j - 1) * bColumn.get(j));
        }
        return results;
    }

    private List<Double> getSecondsTrianglesSquare(List<Double> aColumn,List<Double> bColumn){
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            int j = i + 1;
            if(j > 9){
                results.add(bColumn.get(j - 1) * aColumn.get(0));
                continue;
            }
            results.add(bColumn.get(j - 1) * aColumn.get(j));
        }
        return results;
    }

    private double getTotalSquare(List<Double> firstSquares, List<Double> secondSquares){
        double result = 0;
        for(int i = 0;i < 10;i++){
            result += Math.abs(firstSquares.get(i) - secondSquares.get(i));
        }
        return result;
    }

    private List<Double> getCirclePartsForIndustry(){
       double sum = ExpertsMarksTable.getItems().stream().mapToInt(item -> item.getIndustryExpertMark()).sum();
       ArrayList<Double> results = new ArrayList<>();
       ExpertsMarksTable.getItems().forEach(item -> {
           results.add((item.getIndustryExpertMark()/sum) * 360.0);
       });
       return results;
    }

    private List<Double> getCirclePartsForUsability(){
       double sum = ExpertsMarksTable.getItems().stream().mapToInt(item -> item.getUsabilityExpertMark()).sum();
       ArrayList<Double> results = new ArrayList<>();
       ExpertsMarksTable.getItems().forEach(item -> {
           results.add((item.getUsabilityExpertMark()/sum) * 360.0);
       });
       return results;
    }

    private List<Double> getCirclePartsForProgramming(){
       double sum = ExpertsMarksTable.getItems().stream().mapToInt(item -> item.getProgrammingExpertMark()).sum();
       ArrayList<Double> results = new ArrayList<>();
       ExpertsMarksTable.getItems().forEach(item -> {
           results.add((item.getProgrammingExpertMark()/sum) * 360.0);
       });
       return results;
    }

    private List<Double> getCirclePartsForUsers(){
       double sum = ExpertsMarksTable.getItems().stream().mapToDouble(item ->
       {
           try {
               return NumberFormat.getInstance(Locale.FRANCE).parse(item.getUsersMark()).doubleValue();
           } catch (ParseException e) {
               e.printStackTrace();
           }
           return 0;
       }).sum();
       ArrayList<Double> results = new ArrayList<>();
       ExpertsMarksTable.getItems().forEach(item -> {
           try {
               results.add((NumberFormat.getInstance(Locale.FRANCE).parse(item.getUsersMark()).doubleValue()/sum) * 360.0);
           } catch (ParseException e) {
               e.printStackTrace();
           }
       });
       return results;
    }

    private List<Double> getCirclePartsForAvarage(List<Double> marks){
        double sum = marks.stream().mapToDouble(item -> item).sum();
        List<Double> results = new ArrayList<>();
        marks.forEach(item -> {
            results.add((item/sum) * 360);
        });
//        System.out.println(sum);
        return results;
    }


    private List<Double> getTmpParts(List<Double> circleParts){
        ArrayList<Double> results = new ArrayList<>();
        results.add(0.0);
        results.add(-(circleParts.get(0)/2));
        for(int i = 2;i < 12;i++){
            results.add(results.get(i - 1) + circleParts.get(i - 2));
        }
        return results;
    }


    private List<Double> getDegrees(List<Double> tmpParts){
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 2;i < 12;i++){
            results.add((tmpParts.get(i) + tmpParts.get(i - 1))/2);
        }
        return results;
    }

    private List<Double> getVectorLengthForIndustry(){
        ArrayList<Double> marks = new ArrayList<>();
        ExpertsMarksTable.getItems()
                .stream()
                .forEach(item -> {
                    marks.add((double) item.getIndustryExpertMark());
                });
        ArrayList<Double> validity = new ArrayList<>();
        ValidityTable.getItems().stream().forEach(item -> {
            validity.add((double) item.getUsersExpert());
        });
        double relativeVal = qCoefficientTable.getItems()
                .stream()
                .filter(item -> item.getExpertType().equals("Експерт галузі"))
                .findAny()
                .orElse(null).getRelativeValue();
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            results.add(marks.get(i) * validity.get(i) * relativeVal);
        }
        return results;
    }

    private List<Double> getVectorLengthForUsability(){
        ArrayList<Double> marks = new ArrayList<>();
        ExpertsMarksTable.getItems()
                .stream()
                .forEach(item -> {
                    marks.add((double) item.getUsabilityExpertMark());
                });
        ArrayList<Double> validity = new ArrayList<>();
        ValidityTable.getItems().stream().forEach(item -> {
            validity.add((double) item.getUsabilityExpert());
        });
        double relativeVal = qCoefficientTable.getItems()
                .stream()
                .filter(item -> item.getExpertType().equals("Експерт юзабіліті"))
                .findAny()
                .orElse(null).getRelativeValue();
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            results.add(marks.get(i) * validity.get(i) * relativeVal);
        }
        return results;
    }

    private List<Double> getVectorLengthForProgramming(){
        ArrayList<Double> marks = new ArrayList<>();
        ExpertsMarksTable.getItems()
                .stream()
                .forEach(item -> {
                    marks.add((double) item.getProgrammingExpertMark());
                });
        ArrayList<Double> validity = new ArrayList<>();
        ValidityTable.getItems().stream().forEach(item -> {
            validity.add((double) item.getProgrammingExpert());
        });
        double relativeVal = qCoefficientTable.getItems()
                .stream()
                .filter(item -> item.getExpertType().equals("Експерт з програмування"))
                .findAny()
                .orElse(null).getRelativeValue();
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            results.add(marks.get(i) * validity.get(i) * relativeVal);
        }
        return results;
    }

    private List<Double> getVectorLengthForUsers(){
        ArrayList<Double> marks = new ArrayList<>();
        ExpertsMarksTable.getItems()
                .stream()
                .forEach(item -> {
                    try {
                        marks.add(NumberFormat.getInstance(Locale.FRANCE).parse(item.getUsersMark()).doubleValue());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
        ArrayList<Double> validity = new ArrayList<>();
        ValidityTable.getItems().stream().forEach(item -> {
            validity.add((double) item.getUsersExpert());
        });
        double relativeVal = qCoefficientTable.getItems()
                .stream()
                .filter(item -> item.getExpertType().equals("Потенційні користувачі"))
                .findAny()
                .orElse(null).getRelativeValue();
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            results.add(marks.get(i) * validity.get(i) * relativeVal);
        }
        return results;
    }

    private void fillComplexIndicatorsTable(){
        evaluationCriteriaColumn.setCellValueFactory(new PropertyValueFactory<ComplexIndicatorsTableData,String>("evaluationCriteria"));
        industryExpertsMarkColumn.setCellValueFactory(new PropertyValueFactory<ComplexIndicatorsTableData,Integer>("industryExpertMark"));
        usabilityExpertsMarkColumn.setCellValueFactory(new PropertyValueFactory<ComplexIndicatorsTableData,Integer>("usabilityExpertMark"));
        programmingExpertsMarkColumn.setCellValueFactory(new PropertyValueFactory<ComplexIndicatorsTableData,Integer>("programmingExpertMark"));
        usersMarkColumn.setCellValueFactory(new PropertyValueFactory<ComplexIndicatorsTableData,Double>("userMark"));
        avgMarksSumColumn.setCellValueFactory(new PropertyValueFactory<ComplexIndicatorsTableData,Double>("avgSum"));
        avgMarksXiColumn.setCellValueFactory(new PropertyValueFactory<ComplexIndicatorsTableData,Double>("avgXi"));
        complexIndicatorsTable.setItems(getComplexIndicatorsData());
    }

    private ObservableList<ComplexIndicatorsTableData> getComplexIndicatorsData() {
        ObservableList<ComplexIndicatorsTableData> data = FXCollections.observableArrayList();
        File dataFile = new File("/Users/yuraslipenkyi/Downloads/LabRA6/src/sample/data/data.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        int i = 0;
        while (scanner.hasNextLine()) {
            String curCriteria = scanner.nextLine();
            int industryMark = getIndustryMarkForCriteria(curCriteria);
            int usabilityMark = getUsabilityMarkForCriteria(curCriteria);
            int programmingMark = getProgrammingMarkForCriteria(curCriteria);
            double userMark = new BigDecimal(getUserMarkForCriteria(curCriteria)).setScale(2, RoundingMode.HALF_UP).doubleValue();
            double avgSum = new BigDecimal(getAvgSumForCriteria(industryMark,usabilityMark,programmingMark,userMark)).setScale(2, RoundingMode.HALF_UP).doubleValue();
            double avgXi = new BigDecimal(getAvgXiForCriteria(curCriteria,avgSum)).setScale(2, RoundingMode.HALF_UP).doubleValue();
            data.add(new ComplexIndicatorsTableData(curCriteria,industryMark,usabilityMark,programmingMark,userMark,
                    avgSum,avgXi));
        }
        return data;
    }

    private double getAvgXiForCriteria(String Criteria,double avgSum){
        ValidityTableData validity = ValidityTable.getItems()
                .stream()
                .filter(item -> item.getTitle().equals(Criteria))
                .findAny()
                .orElse(null);
        double avgValidity = (validity.getIndustryExpert() + validity.getUsabilityExpert() +
                validity.getProgrammingExpert() + validity.getUsersExpert()) / 4.0;
        return avgSum/avgValidity;
    }

    private double getAvgSumForCriteria(int industryMark,int usabilityMark,int programmingMark,double userMark){
        double relativeSum = qCoefficientTable.getItems()
                .stream()
                .mapToDouble(QCoefficientTableData::getRelativeValue)
                .sum();
        double industry = industryMark * qCoefficientTable.getItems().get(0).getRelativeValue();
        double usability = usabilityMark * qCoefficientTable.getItems().get(1).getRelativeValue();
        double programming = programmingMark * qCoefficientTable.getItems().get(2).getRelativeValue();
        double user = userMark * qCoefficientTable.getItems().get(3).getRelativeValue();
        return (industry + usability + programming + user)/relativeSum;
    }

    private int getIndustryMarkForCriteria(String criteria){
            int industryValidity = ValidityTable.getItems()
                    .stream()
                    .filter(item -> item.getTitle().equals(criteria))
                    .findAny()
                    .orElse(null)
                    .getIndustryExpert();
            int industryMark = ExpertsMarksTable.getItems()
                    .stream()
                    .filter(item -> item.getCriteriaTitle().equals(criteria))
                    .findAny()
                    .orElse(null).getIndustryExpertMark();
            return industryValidity * industryMark;
    }

    private int getUsabilityMarkForCriteria(String criteria){
            int usabilityValidity = ValidityTable.getItems()
                    .stream()
                    .filter(item -> item.getTitle().equals(criteria))
                    .findAny()
                    .orElse(null)
                    .getUsabilityExpert();
            int usabilityMark = ExpertsMarksTable.getItems()
                    .stream()
                    .filter(item -> item.getCriteriaTitle().equals(criteria))
                    .findAny()
                    .orElse(null).getUsabilityExpertMark();
            return usabilityValidity * usabilityMark;
    }

    private int getProgrammingMarkForCriteria(String criteria){
            int programmingValidity = ValidityTable.getItems()
                    .stream()
                    .filter(item -> item.getTitle().equals(criteria))
                    .findAny()
                    .orElse(null)
                    .getProgrammingExpert();
            int programmingMark = ExpertsMarksTable.getItems()
                    .stream()
                    .filter(item -> item.getCriteriaTitle().equals(criteria))
                    .findAny()
                    .orElse(null).getIndustryExpertMark();
            return programmingMark * programmingValidity;
    }

    private double getUserMarkForCriteria(String criteria){
            int userValidity = ValidityTable.getItems()
                    .stream()
                    .filter(item -> item.getTitle().equals(criteria))
                    .findAny()
                    .orElse(null)
                    .getUsersExpert();
            String userMarkString = ExpertsMarksTable.getItems()
                    .stream()
                    .filter(item -> item.getCriteriaTitle().equals(criteria))
                    .findAny()
                    .orElse(null).getUsersMark();
            double userMark = 0;
            try {
                userMark = NumberFormat.getInstance(Locale.FRANCE).parse(userMarkString).doubleValue();
              } catch (ParseException e) {
            e.printStackTrace();
        }
        return userMark * userValidity;
    }


    private void fillQCoefficientTable(){
        expertTypeColumn.setCellValueFactory(new PropertyValueFactory<QCoefficientTableData,String>("expertType"));
        absoluteValueColumn.setCellValueFactory(new PropertyValueFactory<QCoefficientTableData,Integer>("absoluteValue"));
        relativeValueColumn.setCellValueFactory(new PropertyValueFactory<QCoefficientTableData,Double>("relativeValue"));
        qCoefficientTable.setItems(getQCoefficientData());
    }

    private ObservableList<QCoefficientTableData> getQCoefficientData(){
        ObservableList<QCoefficientTableData> data = FXCollections.observableArrayList();
        data.add(new QCoefficientTableData("Експерт галузі"));
        data.add(new QCoefficientTableData("Експерт юзабіліті"));
        data.add(new QCoefficientTableData("Експерт з програмування"));
        data.add(new QCoefficientTableData("Потенційні користувачі"));
        return data;
    }

    private void fillExpertsTableMarks(){
        сriteriaColumn.setCellValueFactory(new PropertyValueFactory<ExpertsMarksData,String>("criteriaTitle"));
        IndustryExpertColumn.setCellValueFactory(new PropertyValueFactory<ExpertsMarksData,Integer>("industryExpertMark"));
        UsabilityExpertColumn.setCellValueFactory(new PropertyValueFactory<ExpertsMarksData,Integer>("usabilityExpertMark"));
        ProgrammingExpertColumn.setCellValueFactory(new PropertyValueFactory<ExpertsMarksData,Integer>("programmingExpertMark"));
        UsersExpertColumn.setCellValueFactory(new PropertyValueFactory<ExpertsMarksData,String>("usersMark"));
        ExpertsMarksTable.setItems(getExpertsMarksData());
    }

    private ObservableList<ExpertsMarksData> getExpertsMarksData(){
        ObservableList<ExpertsMarksData> data = FXCollections.observableArrayList();
        ObservableList<TableColumn> userMarksColumns = UsersMarksTable.getColumns();
        File dataFile = new File("/Users/yuraslipenkyi/Downloads/LabRA6/src/sample/data/data.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        int i = 0;
        while(scanner.hasNextLine()){
            data.add(new ExpertsMarksData(scanner.nextLine(),String.format("%.2f",getUserMarkAvgForRow(i,userMarksColumns))));
            i++;
        }
        return data;
    }

    private double getUserMarkAvgForRow(int r,ObservableList<TableColumn> userMarksColumns){
        double avg = 0;
        for(int i = 0;i < 20;i++){
            avg += (int)userMarksColumns.get(i).getCellObservableValue(r).getValue();
        }
        return avg/20.0;
    }


    private void fillUserMarksTable(){
        u1.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u1"));
        u2.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u2"));
        u3.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u3"));
        u4.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u4"));
        u5.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u5"));
        u6.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u6"));
        u7.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u7"));
        u8.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u8"));
        u9.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u9"));
        u10.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u10"));
        u11.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u11"));
        u12.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u12"));
        u13.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u13"));
        u14.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u14"));
        u15.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u15"));
        u16.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u16"));
        u17.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u17"));
        u18.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u18"));
        u19.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u19"));
        u20.setCellValueFactory(new PropertyValueFactory<UserMarksData,Integer>("u20"));
        UsersMarksTable.setItems(getUserMarksData());
    }

    private ObservableList<UserMarksData> getUserMarksData(){
        ObservableList<UserMarksData> data = FXCollections.observableArrayList();
        for(int i = 0;i < 15;i++){
            data.add(new UserMarksData());
        }
        return data;
    }

    private void fillValidityTable(){
        CriteriaNumber.setCellValueFactory(new PropertyValueFactory<ValidityTableData,Integer>("number"));
        CriteriaName.setCellValueFactory(new PropertyValueFactory<ValidityTableData,Integer>("title"));
        IndustryExpert.setCellValueFactory(new PropertyValueFactory<ValidityTableData,Integer>("industryExpert"));
        UsabilityExpert.setCellValueFactory(new PropertyValueFactory<ValidityTableData,Integer>("usabilityExpert"));
        ProgrammingExpert.setCellValueFactory(new PropertyValueFactory<ValidityTableData,Integer>("programmingExpert"));
        UsersExpert.setCellValueFactory(new PropertyValueFactory<ValidityTableData,Integer>("usersExpert"));
        ValidityTable.setItems(getValidityData());
    }

    private ObservableList<ValidityTableData> getValidityData(){
        ObservableList<ValidityTableData> data = FXCollections.observableArrayList();
        File dataFile = new File("/Users/yuraslipenkyi/Downloads/LabRA6/src/sample/data/data.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        int i = 1;
        while(scanner.hasNextLine()){
            data.add(new ValidityTableData(i,scanner.nextLine()));
            i++;
        }
        return data;
    }

    public void onFillUserMarks(ActionEvent event) {
        fillUserMarksTable();
    }

    public void onFillValidityCoeficients(ActionEvent event) {
        fillValidityTable();
    }

    public void onFillExpertsMarks(ActionEvent event) {
        fillExpertsTableMarks();
    }

    public void onFillQCoefficient(ActionEvent event) {
        fillQCoefficientTable();
    }

    public void onFillComplexIndicators(ActionEvent event) {
        fillComplexIndicatorsTable();
    }

    public void onIndustryWeb(ActionEvent event) {
        List<Double> iCircleParts = getCirclePartsForIndustry();
        List<Double> iTmpParts = getTmpParts(iCircleParts);
        List<Double> iDegrees = getDegrees(iTmpParts);
        List<Double> iLengths = getVectorLengthForIndustry();
        industryWebView.getEngine().executeScript("drawChart(" + iDegrees + ","+ iLengths + ")");
        List<Double> aColumn = getAColumn(iLengths,iDegrees);
        List<Double> bColumn = getBColumn(iLengths,iDegrees);
        List<Double> firstTriangles = getFirstsTrianglesSquare(aColumn,bColumn);
        List<Double> secondTriangles = getSecondsTrianglesSquare(aColumn,bColumn);
        double resultSquare = getTotalSquare(firstTriangles,secondTriangles);
        industrySquareLabel.setText("Площа - " + String.format("%.2f",resultSquare));
    }

    public void onUsabilityWebView(ActionEvent event) {
        List<Double> uCircleParts = getCirclePartsForUsability();
        List<Double> uTmpParts = getTmpParts(uCircleParts);
        List<Double> uDegrees = getDegrees(uTmpParts);
        List<Double> uLengths = getVectorLengthForUsability();
        usabilityWebView.getEngine().executeScript("drawChart(" + uDegrees + ","+ uLengths + ")");
        List<Double> aColumn = getAColumn(uLengths,uDegrees);
        List<Double> bColumn = getBColumn(uLengths,uDegrees);
        List<Double> firstTriangles = getFirstsTrianglesSquare(aColumn,bColumn);
        List<Double> secondTriangles = getSecondsTrianglesSquare(aColumn,bColumn);
        double resultSquare = getTotalSquare(firstTriangles,secondTriangles);
        usabilitySquareLabel.setText("Площа - " + String.format("%.2f",resultSquare));
    }

    public void onUsersWebView(ActionEvent event) {
        List<Double> usCircleParts = getCirclePartsForUsers();
        List<Double> usTmpParts = getTmpParts(usCircleParts);
        List<Double> usDegrees = getDegrees(usTmpParts);
        List<Double> usLengths = getVectorLengthForUsers();
        usersWebView.getEngine().executeScript("drawChart(" + usDegrees + ","+ usLengths + ")");
        List<Double> aColumn = getAColumn(usLengths,usDegrees);
        List<Double> bColumn = getBColumn(usLengths,usDegrees);
        List<Double> firstTriangles = getFirstsTrianglesSquare(aColumn,bColumn);
        List<Double> secondTriangles = getSecondsTrianglesSquare(aColumn,bColumn);
        double resultSquare = getTotalSquare(firstTriangles,secondTriangles);
        usersSquareLabel.setText("Площа - " + String.format("%.2f",resultSquare));
    }

    public void onProgrammingWebView(ActionEvent event) {
        List<Double> pCircleParts = getCirclePartsForProgramming();
        List<Double> pTmpParts = getTmpParts(pCircleParts);
        List<Double> pDegrees = getDegrees(pTmpParts);
        List<Double> pLengths = getVectorLengthForProgramming();
        programmingWebView.getEngine().executeScript("drawChart(" + pDegrees + ","+ pLengths + ")");
        List<Double> aColumn = getAColumn(pLengths,pDegrees);
        List<Double> bColumn = getBColumn(pLengths,pDegrees);
        List<Double> firstTriangles = getFirstsTrianglesSquare(aColumn,bColumn);
        List<Double> secondTriangles = getSecondsTrianglesSquare(aColumn,bColumn);
        double resultSquare = getTotalSquare(firstTriangles,secondTriangles);
        programmingSquareLabel.setText("Площа - " + String.format("%.2f",resultSquare));
    }

    public void onGeneralWebView(ActionEvent event) {
        List<Double> iCircleParts = getCirclePartsForIndustry();
        List<Double> iTmpParts = getTmpParts(iCircleParts);
        List<Double> iDegrees = getDegrees(iTmpParts);
        List<Double> iLengths = getVectorLengthForIndustry();

        List<Double> uCircleParts = getCirclePartsForUsability();
        List<Double> uTmpParts = getTmpParts(uCircleParts);
        List<Double> uDegrees = getDegrees(uTmpParts);
        List<Double> uLengths = getVectorLengthForUsability();

        List<Double> pCircleParts = getCirclePartsForProgramming();
        List<Double> pTmpParts = getTmpParts(pCircleParts);
        List<Double> pDegrees = getDegrees(pTmpParts);
        List<Double> pLengths = getVectorLengthForProgramming();

        List<Double> usCircleParts = getCirclePartsForUsers();
        List<Double> usTmpParts = getTmpParts(usCircleParts);
        List<Double> usDegrees = getDegrees(usTmpParts);
        List<Double> usLengths = getVectorLengthForUsers();

        generalWebView.getEngine().executeScript("drawGeneralChart(" + iDegrees + ","+ iLengths + ","
                + uDegrees + "," + uLengths + "," + pDegrees + ","+ pLengths + "," + usDegrees + ","+ usLengths + ")");
    }

    public void onAvarageWebView(ActionEvent event) {
        List<ExpertsMarksData> expertMarks = ExpertsMarksTable.getItems().stream().collect(Collectors.toList());
        ArrayList<Double> avarageMarks = new ArrayList<>();
        expertMarks.forEach(item -> {
            try {
                avarageMarks.add((item.getIndustryExpertMark() + item.getUsabilityExpertMark() +
                        item.getProgrammingExpertMark() + NumberFormat.getInstance(Locale.FRANCE).parse(item.getUsersMark()).doubleValue())/4.0);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
//        System.out.println(avarageMarks);
        List<Double> aCircleParts = getCirclePartsForAvarage(avarageMarks);
//        System.out.println(aCircleParts);
        List<Double> aTmpParst = getTmpParts(aCircleParts);
        System.out.println(aTmpParst);
        List<Double> aDegrees = getDegrees(aTmpParst);
        System.out.println(aDegrees);
        List<Double> aLengths = new ArrayList<>();
        complexIndicatorsTable.getItems()
                .stream()
                .forEach(item -> aLengths.add(item.getAvgSum()));
        System.out.println(aLengths);
        avarageWebView.getEngine().executeScript("drawChart(" + aDegrees + ","+ aLengths + ")");
        List<Double> aColumn = getAColumn(aLengths,aDegrees);
        List<Double> bColumn = getBColumn(aLengths,aDegrees);
        List<Double> firstsTriangles = getFirstsTrianglesSquare(aColumn,bColumn);
        List<Double> secondTriangles = getSecondsTrianglesSquare(aColumn,bColumn);
        double resultSquare = getTotalSquare(firstsTriangles,secondTriangles);
        avarageSquareLabel.setText("Площа - " + String.format("%.2f",resultSquare));
    }
}
