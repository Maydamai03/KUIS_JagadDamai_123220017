/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applomba;

/**
 *
 * @author Lab Informatika
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AppLomba extends JFrame {

    private String tipeLomba;
    private String namaMurid;
    private String asalSekolah;
    private int alurCeritaA;
    private int kontenA;
    private int kreativitasA;
    private int sinematografiA;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JButton animasiButton;
    private JButton suratButton;
    private JTextField namaField;
    private JTextField asalSekolahField;
    private JTextField alurCeritaAField;
    private JTextField kontenAField;
    private JTextField kreativitasAField;
    private JTextField sinematografiAField;
    private JButton saveButton;
    private JLabel namaLabel;
    private JLabel asalSekolahLabel;
    private JLabel alurCeritaLabel;
    private JLabel kontenALabel;
    private JLabel kreativitasALabel;
    private JLabel sinematografiALabel;
    private JButton finishButton;

    public AppLomba() {

        setTitle("Aplikasi Nilai Peserta");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2 = new JPanel(new GridLayout(7, 2));
        panel3 = new JPanel(new GridLayout(8, 2));

        animasiButton = new JButton("ANIMASI");
        suratButton = new JButton("SURAT");

        panel1.add(animasiButton);
        panel1.add(suratButton);

        namaField = new JTextField(10);
        asalSekolahField = new JTextField(20);
        alurCeritaAField = new JTextField(3);
        kontenAField = new JTextField(3);
        kreativitasAField = new JTextField(3);
        sinematografiAField = new JTextField(3);
        saveButton = new JButton("Simpan");

        panel2.add(new JLabel("Nama siswa: "));
        panel2.add(namaField);
        panel2.add(new JLabel("Asal Sekolah: "));
        panel2.add(asalSekolahField);
        panel2.add(new JLabel("Nilai Alur Cerita: "));
        panel2.add(alurCeritaAField);
        panel2.add(new JLabel("Nilai Konten: "));
        panel2.add(kontenAField);
        panel2.add(new JLabel("Nilai Kreativitas: "));
        panel2.add(kreativitasAField);
        panel2.add(new JLabel("Nilai Sinematografi: "));
        panel2.add(sinematografiAField);
        panel2.add(saveButton);

        namaLabel = new JLabel();
        asalSekolahLabel = new JLabel();
        alurCeritaLabel = new JLabel();
        kontenALabel = new JLabel();
        kreativitasALabel = new JLabel();
        sinematografiALabel = new JLabel();
        finishButton = new JButton("Selesai");

        panel3.add(namaLabel);
        panel3.add(asalSekolahLabel);
        panel3.add(alurCeritaLabel);
        panel3.add(kontenALabel);
        panel3.add(kreativitasALabel);
        panel3.add(sinematografiALabel);
        panel3.add(finishButton);

        animasiButton.addActionListener(e -> {
            tipeLomba = "Animasi";
            showDetailLomba();
        });

        suratButton.addActionListener(e -> {
            tipeLomba = "Surat";
            showDetailLomba();
        });

        saveButton.addActionListener(e -> {
            namaMurid = namaField.getText();
            asalSekolah = asalSekolahField.getText();
            alurCeritaA = Integer.parseInt(alurCeritaAField.getText());
            kontenA = Integer.parseInt(kontenAField.getText());
            kreativitasA = Integer.parseInt(kreativitasAField.getText());
            sinematografiA = Integer.parseInt(sinematografiAField.getText());
            Summary();
        });

        finishButton.addActionListener(e -> dispose());

        add(panel1);
        setVisible(true);
    }

    private void showChoiceLomba() {
        getContentPane().removeAll();
        add(panel1);
        revalidate();
        repaint();
    }

    private void showDetailLomba() {
        getContentPane().removeAll();
        add(panel2);
        revalidate();
        repaint();
    }

    private void Summary() {
    getContentPane().removeAll();

    double totalNilai = (alurCeritaA * 0.15) + (kontenA * 0.35) + (kreativitasA * 0.35) + (sinematografiA * 0.15);
    String status = (totalNilai > 85) ? "ANDA LULUS YHAHAHAHA" : "SORRY TIDAK LULUS CHUAAKSSSS";

    namaLabel.setText("Nama Peserta: " + namaMurid);
    asalSekolahLabel.setText("Asal Sekolah: " + asalSekolah);
    alurCeritaLabel.setText("Nilai Alur Cerita: " + alurCeritaA);
    kontenALabel.setText("Nilai Konten: " + kontenA);
    kreativitasALabel.setText("Nilai Kreativitas: " + kreativitasA);
    sinematografiALabel.setText("Nilai Sinematografi: " + sinematografiA);
    panel3.add(new JLabel("Total Nilai: " + totalNilai));
    panel3.add(new JLabel("Status: " + status));

    add(panel3);
    revalidate();
    repaint();
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppLomba::new);
    }
}

