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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jfree.chart.plot.PiePlot;

public class PieChartLaporan implements GrafikLaporan {
    @Override
    public void showChart() {
        try {
            DefaultPieDataset dataset = new DefaultPieDataset();
            Statement st = KONEKSI.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT `TIPE KENDARAAN`, SUM(`STOK KELUAR`) AS jumlah FROM ban_masuk GROUP BY `TIPE KENDARAAN`");

            while (rs.next()) {
                dataset.setValue(rs.getString("TIPE KENDARAAN"), rs.getDouble("jumlah"));
            }

            // Membuat pie chart
            JFreeChart chart = ChartFactory.createPieChart(
                    "Distribusi Stok Keluar Berdasarkan Tipe Kendaraan",
                    dataset, 
                    true,  // include legend
                    true,  // use tooltips
                    false  // URLs disabled
            );

            // Menambahkan label angka dan persentase
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                    "{0} : {1} ({2})", // Format: {0}=key, {1}=value, {2}=percentage
                    new java.text.DecimalFormat("#,##0"),   // Format untuk value
                    new java.text.DecimalFormat("0.0%")     // Format untuk persentase
            ));

            displayChart(chart, "Grafik Pie Chart");
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