/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BENGKELBAN;

/**
 *
 * @author syukr
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class BarChartLaporan implements GrafikLaporan {
    @Override
    public void showChart() {
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            Statement st = KONEKSI.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MEREK, SUM(`STOK KELUAR`) AS jumlah FROM ban_masuk GROUP BY MEREK");

            while (rs.next()) {
                dataset.addValue(rs.getDouble("jumlah"), "Stok Keluar", rs.getString("MEREK"));
            }
 
            JFreeChart chart = ChartFactory.createBarChart(
                    "Stok Keluar Berdasarkan Merek",
                    "Merek", "Jumlah Stok Keluar", dataset);

            displayChart(chart, "Grafik Bar Chart");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saat membuat grafik: " + e.getMessage());
        }
    }

    private void displayChart(JFreeChart chart, String title) {
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(chartPanel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
