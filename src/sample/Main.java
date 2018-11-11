package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.String.valueOf;

public class Main extends Application {
    TextField textFieldSeiteA;
    TextField textFieldSeiteB;
    TextField textFieldSeiteC;
    TextField textFieldAlpha;
    TextField textFieldBeta;
    TextField textFieldGamma;

    private void berrechneMitSeiteASeiteBSeiteC() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double gamma = Math.toDegrees(Math.acos((Math.pow(seiteA, 2) + Math.pow(seiteB, 2) - Math.pow(seiteC, 2)) / (2 * seiteA * seiteB)));
        double beta = sinusMitWinkel(seiteB, seiteC, gamma);
        textFieldGamma.setText(valueOf(gamma));
        textFieldBeta.setText(valueOf(beta));
        textFieldAlpha.setText(valueOf(180 - gamma - beta));
    }

    private void berechneMitSeiteASeiteBWinkelA() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = sinusMitWinkel(seiteB, seiteA, winkelAlpha);
        double winkelGamma = 180 - winkelAlpha - winkelBeta;
        double seiteC = sinusMitSeiten(seiteA, winkelGamma, winkelAlpha);
        textFieldSeiteC.setText(valueOf(seiteC));
        textFieldBeta.setText(valueOf(winkelBeta));
        textFieldGamma.setText(valueOf(winkelGamma));
    }

    private void berechneMitSeiteASeiteBWinkelB() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelAlpha = sinusMitWinkel(seiteA, seiteB, winkelBeta);
        double winkelGamma = 180 - winkelAlpha - winkelBeta;
        double seiteC = sinusMitSeiten(seiteA, winkelGamma, winkelAlpha);

        textFieldSeiteC.setText(valueOf(seiteC));
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldGamma.setText(valueOf(winkelGamma));
    }

    private void berechneMitSeiteASeiteBWinkelC() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double seiteC = cosinusMitSeiten(seiteA, seiteB, winkelGamma);
        double winkelAlpha = sinusMitWinkel(seiteA, seiteC, winkelGamma);
        textFieldSeiteC.setText(valueOf(seiteC));
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldBeta.setText(valueOf(180 - winkelAlpha - winkelGamma));
    }

    private void berechneMitSeiteBSeiteCWinkelA() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double seiteA = cosinusMitSeiten(seiteB, seiteC, winkelAlpha);
        double winkelBeta = sinusMitWinkel(seiteB, seiteA, winkelAlpha);
        textFieldSeiteA.setText(valueOf(seiteA));
        textFieldBeta.setText(valueOf(winkelBeta));
        textFieldGamma.setText(valueOf(180 - winkelAlpha - winkelBeta));
    }

    private void berechneMitSeiteBSeiteCWinkelB() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = sinusMitWinkel(seiteC, seiteB, winkelBeta);
        double winkelAlpha = 180 - winkelBeta - winkelGamma;
        double seiteA = sinusMitSeiten(seiteB, winkelAlpha, winkelBeta);
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldSeiteA.setText(valueOf(seiteA));
        textFieldGamma.setText(valueOf(winkelGamma));
    }

    private void berechneMitSeiteBSeiteCWinkelC() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelBeta = sinusMitWinkel(seiteB, seiteC, winkelGamma);
        double winkelAlpha = 180 - winkelBeta - winkelGamma;
        double seiteA = sinusMitSeiten(seiteC, winkelAlpha, winkelGamma);
        textFieldSeiteA.setText(valueOf(seiteA));
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldBeta.setText(valueOf(winkelBeta));
    }

    private void berechneMitSeiteASeiteCWinkelA() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelGamma = sinusMitWinkel(seiteC, seiteA, winkelAlpha);
        double winkelBeta = 180 - winkelAlpha - winkelGamma;
        double seiteB = sinusMitSeiten(seiteA, winkelBeta, winkelAlpha);
        textFieldSeiteB.setText(valueOf(seiteB));
        textFieldBeta.setText(valueOf(winkelBeta));
        textFieldGamma.setText(valueOf(winkelGamma));
    }

    private void berechneMitSeiteASeiteCWinkelB() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double seiteB = cosinusMitSeiten(seiteA, seiteC, winkelBeta);
        double winkelAlpha = sinusMitWinkel(seiteA, seiteB, winkelBeta);
        textFieldSeiteB.setText(valueOf(seiteB));
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldGamma.setText(valueOf(180 - winkelAlpha - winkelBeta));
    }

    private void berechneMitSeiteASeiteCWinkelC() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelAlpha = sinusMitWinkel(seiteA, seiteC, winkelGamma);
        double winkelBeta = 180 - winkelAlpha - winkelGamma;
        double seiteB = sinusMitSeiten(seiteA, winkelBeta, winkelAlpha);
        textFieldSeiteB.setText(valueOf(seiteB));
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldBeta.setText(valueOf(winkelBeta));
    }

    private void berechneMitSeiteCWinkelAWinkelBWinkelC() {
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double seiteB = sinusMitSeiten(seiteC, winkelBeta, winkelGamma);
        double seiteA = sinusMitSeiten(seiteB, winkelAlpha, winkelBeta);
        textFieldSeiteA.setText(valueOf(seiteA));
        textFieldSeiteB.setText(valueOf(seiteB));
    }

    private void berecheMitSeiteBWinkelAWinkelBWinkelC() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double seiteA = sinusMitSeiten(seiteB, winkelAlpha, winkelBeta);
        double seiteC = sinusMitSeiten(seiteA, winkelGamma, winkelAlpha);
        textFieldSeiteA.setText(valueOf(seiteA));
        textFieldSeiteC.setText(valueOf(seiteC));
    }

    private void berechneMitSeiteBSeiteCWinkelBWinkelC() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelAlpha = 180 - winkelBeta - winkelGamma;
        double seiteA = sinusMitSeiten(seiteB, winkelAlpha, winkelBeta);
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldSeiteA.setText(valueOf(seiteA));
    }

    private void berechneMitSeiteBSeiteCWinkelAWinkelC() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelBeta = 180 - winkelAlpha - winkelGamma;
        double seiteA = sinusMitSeiten(seiteB, winkelAlpha, winkelBeta);
        textFieldSeiteA.setText(valueOf(seiteA));
        textFieldBeta.setText(valueOf(winkelBeta));
    }

    private void berechneMitSeiteBSeiteCWinkelAWinkelB() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double seiteA = sinusMitSeiten(seiteB, winkelAlpha, winkelBeta);
        textFieldGamma.setText(valueOf(180 - winkelAlpha - winkelBeta));
        textFieldSeiteA.setText(valueOf(seiteA));
    }

    private void berechneMitSeiteAWinkelAWinkelBWinkelC() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double seiteB = sinusMitSeiten(seiteA, winkelBeta, winkelAlpha);
        double seiteC = sinusMitSeiten(seiteA, winkelGamma, winkelAlpha);
        textFieldSeiteC.setText(valueOf(seiteC));
        textFieldSeiteB.setText(valueOf(seiteB));
    }

    private void berechneMitSeiteASeiteCWinkelBWinkelC() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelAlpha = 180 - winkelBeta - winkelGamma;
        double seiteB = sinusMitSeiten(seiteA, winkelBeta, winkelAlpha);
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldSeiteB.setText(valueOf(seiteB));
    }

    private void berechneMitSeiteASeiteCWinkelAWinkelC() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = 180 - winkelAlpha - winkelGamma;
        double seiteB = sinusMitSeiten(seiteA, winkelBeta, winkelAlpha);
        textFieldSeiteB.setText(valueOf(seiteB));
        textFieldBeta.setText(valueOf(winkelBeta));
    }

    private void berechneMitSeiteASeiteCWinkelAWinkelB() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = 180 - winkelAlpha - winkelBeta;
        double seiteB = sinusMitSeiten(seiteA, winkelBeta, winkelAlpha);
        textFieldGamma.setText(valueOf(winkelGamma));
        textFieldSeiteB.setText(valueOf(seiteB));
    }

    private void berechneMitSeiteASeiteBWinkelBWinkelC() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelAlpha = 180 - winkelBeta - winkelGamma;
        double seiteC = sinusMitSeiten(seiteA, winkelGamma, winkelAlpha);
        textFieldAlpha.setText(valueOf(winkelAlpha));
        textFieldSeiteC.setText(valueOf(seiteC));
    }

    private void berechneMitSeiteASeiteBWinkelAWinkelC() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = 180 - winkelAlpha - winkelGamma;
        double seiteC = sinusMitSeiten(seiteA, winkelGamma, winkelAlpha);
        textFieldBeta.setText(valueOf(winkelBeta));
        textFieldSeiteC.setText(valueOf(seiteC));
    }

    private void berechneMitSeiteASeiteBWinkelAWinkelB() {
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = 180 - winkelAlpha - winkelBeta;
        double seiteC = sinusMitSeiten(seiteA, winkelGamma, winkelAlpha);
        textFieldSeiteC.setText(valueOf(seiteC));
        textFieldGamma.setText(valueOf(winkelGamma));
    }

    private void berechneMitSeiteASeiteBSeiteCWinkelC() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelGamma = Double.parseDouble(textFieldGamma.getText());
        double winkelBeta = sinusMitWinkel(seiteB, seiteC, winkelGamma);
        textFieldAlpha.setText(valueOf(180 - winkelBeta - winkelGamma));
        textFieldBeta.setText(valueOf(winkelBeta));
    }

    private void berechneMitSeiteASeiteBSeiteCWinkelB() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double seiteC = Double.parseDouble(textFieldSeiteC.getText());
        double winkelBeta = Double.parseDouble(textFieldBeta.getText());
        double winkelGamma = sinusMitWinkel(seiteC, seiteB, winkelBeta);
        textFieldGamma.setText(valueOf(winkelGamma));
        textFieldAlpha.setText(valueOf(180 - winkelBeta - winkelGamma));
    }

    private void berechneMitSeiteASeiteBSeiteCWinkelA() {
        double seiteB = Double.parseDouble(textFieldSeiteB.getText());
        double seiteA = Double.parseDouble(textFieldSeiteA.getText());
        double winkelAlpha = Double.parseDouble(textFieldAlpha.getText());
        double winkelBeta = sinusMitWinkel(seiteB, seiteA, winkelAlpha);
        textFieldBeta.setText(valueOf(winkelBeta));
        textFieldGamma.setText(valueOf(180 - winkelAlpha - winkelBeta));
    }

    private void berechne1SeiteMit5Werte(double seite1, double seite2, double winkel1, TextField leeresTextfield) {
        leeresTextfield.setText(valueOf(sinusMitSeiten(seite1, seite2, winkel1)));
    }

    private void berechne1WinkelMit5Werte(double seite1, double seite2, double winkel1, TextField leeresTextfield) {
        leeresTextfield.setText(valueOf(sinusMitWinkel(seite1, seite2, winkel1)));
    }

    private void decisionHandler() {
        if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berrechneMitSeiteASeiteBSeiteC();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBWinkelA();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBWinkelB();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBWinkelC();
        } else if (textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteBSeiteCWinkelA();
        } else if (textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteBSeiteCWinkelB();
        } else if (textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteBSeiteCWinkelC();
        } else if (!textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteCWinkelA();
        } else if (!textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteCWinkelB();
        } else if (!textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteCWinkelC();
        } else if (textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteCWinkelAWinkelBWinkelC();
        } else if (textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berecheMitSeiteBWinkelAWinkelBWinkelC();
        } else if (textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteBSeiteCWinkelBWinkelC();
        } else if (textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteBSeiteCWinkelAWinkelC();
        } else if (textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteBSeiteCWinkelAWinkelB();
        } else if (!textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteAWinkelAWinkelBWinkelC();
        } else if (!textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteCWinkelBWinkelC();
        } else if (!textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteCWinkelAWinkelC();
        } else if (!textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteCWinkelAWinkelB();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBWinkelBWinkelC();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBWinkelAWinkelC();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBWinkelAWinkelB();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBSeiteCWinkelC();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBSeiteCWinkelB();
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechneMitSeiteASeiteBSeiteCWinkelA();
        } else if (textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechne1SeiteMit5Werte(Double.parseDouble(textFieldSeiteB.getText()), Double.parseDouble(textFieldAlpha.getText()), Double.parseDouble(textFieldBeta.getText()), textFieldSeiteA);
        } else if (!textFieldSeiteA.getText().isEmpty() && textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechne1SeiteMit5Werte(Double.parseDouble(textFieldSeiteA.getText()), Double.parseDouble(textFieldBeta.getText()), Double.parseDouble(textFieldAlpha.getText()), textFieldSeiteB);
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechne1SeiteMit5Werte(Double.parseDouble(textFieldSeiteA.getText()), Double.parseDouble(textFieldGamma.getText()), Double.parseDouble(textFieldAlpha.getText()), textFieldSeiteC);
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechne1WinkelMit5Werte(Double.parseDouble(textFieldSeiteA.getText()), Double.parseDouble(textFieldSeiteB.getText()), Double.parseDouble(textFieldBeta.getText()), textFieldAlpha);
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && textFieldBeta.getText().isEmpty() && !textFieldGamma.getText().isEmpty()) {
            berechne1WinkelMit5Werte(Double.parseDouble(textFieldSeiteB.getText()), Double.parseDouble(textFieldSeiteA.getText()), Double.parseDouble(textFieldAlpha.getText()), textFieldBeta);
        } else if (!textFieldSeiteA.getText().isEmpty() && !textFieldSeiteB.getText().isEmpty() && !textFieldSeiteC.getText().isEmpty() && !textFieldAlpha.getText().isEmpty() && !textFieldBeta.getText().isEmpty() && textFieldGamma.getText().isEmpty()) {
            berechne1WinkelMit5Werte(Double.parseDouble(textFieldSeiteC.getText()), Double.parseDouble(textFieldSeiteA.getText()), Double.parseDouble(textFieldAlpha.getText()), textFieldGamma);
        }
    }

    public double sinusMitSeiten(double seite1, double winkel1, double winkel2) {
        return (seite1 * Math.sin(Math.toRadians(winkel1))) / (Math.sin(Math.toRadians(winkel2)));
    }

    public double sinusMitWinkel(double seite1, double seite2, double winkel) {
        return Math.toDegrees(Math.asin((seite1 / seite2) * Math.sin(Math.toRadians(winkel))));
    }

    public double cosinusMitSeiten(double seite1, double seite2, double winkel) {
        return Math.sqrt(Math.pow(seite1, 2) + Math.pow(seite2, 2) - 2 * seite1 * seite2 * Math.cos(Math.toRadians(winkel)));
    }

    private void clearAllFields(){
        textFieldSeiteA.clear();
        textFieldSeiteB.clear();
        textFieldSeiteC.clear();
        textFieldAlpha.clear();
        textFieldBeta.clear();
        textFieldGamma.clear();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane rootPane = new Pane();
        rootPane.setPrefSize(400, 400);

        Label seiteA = new Label();
        seiteA.setText("Seite A:");
        seiteA.relocate(20, 10);

        textFieldSeiteA = new TextField();
        textFieldSeiteA.relocate(20, 30);

        Label seiteB = new Label();
        seiteB.setText("Seite B:");
        seiteB.relocate(20, 60);

        textFieldSeiteB = new TextField();
        textFieldSeiteB.relocate(20, 80);

        Label seiteC = new Label();
        seiteC.setText("Seite C:");
        seiteC.relocate(20, 110);

        textFieldSeiteC = new TextField();
        textFieldSeiteC.relocate(20, 130);

        Label winkelAlpha = new Label();
        winkelAlpha.setText("Winkel α:");
        winkelAlpha.relocate(20, 180);

        textFieldAlpha = new TextField();
        textFieldAlpha.relocate(20, 200);

        Label winkelBeta = new Label();
        winkelBeta.setText("Winkel β:");
        winkelBeta.relocate(20, 230);

        textFieldBeta = new TextField();
        textFieldBeta.relocate(20, 250);

        Label winkelGamma = new Label();
        winkelGamma.setText("Winkel γ:");
        winkelGamma.relocate(20, 280);

        textFieldGamma = new TextField();
        textFieldGamma.relocate(20, 300);

        Button berechnungsButton = new Button();
        berechnungsButton.setText("Berechnen");
        berechnungsButton.relocate(20, 330);

        Button clearButton = new Button();
        clearButton.setText("Clear");
        clearButton.relocate(115, 330);

        rootPane.getChildren().add(textFieldSeiteA);
        rootPane.getChildren().add(textFieldSeiteB);
        rootPane.getChildren().add(textFieldSeiteC);
        rootPane.getChildren().add(textFieldAlpha);
        rootPane.getChildren().add(winkelAlpha);
        rootPane.getChildren().add(textFieldBeta);
        rootPane.getChildren().add(textFieldGamma);
        rootPane.getChildren().add(winkelBeta);
        rootPane.getChildren().add(winkelGamma);
        rootPane.getChildren().add(seiteB);
        rootPane.getChildren().add(seiteA);
        rootPane.getChildren().add(seiteC);
        rootPane.getChildren().add(berechnungsButton);
        rootPane.getChildren().add(clearButton);

        berechnungsButton.setOnAction(event -> decisionHandler());
        clearButton.setOnAction(event -> clearAllFields());

        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Dreiecksberechner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
