package Kasir;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.*;
import java.util.*;
import java.util.Timer;

public class View extends JFrame {
    JPanel jPanel = new jPanelGradient();
    JPanel jPanel1 = new jPanelGradient();
    JPanel jPanel2 = new jPanelGradient();
    JLabel kasir, ldate, lname, lno, fname, fno, lcari, alamat;
    JTextField total = new JTextField("0");
    JTextField ltime = new JTextField(120);
    JTextField fcari = new JTextField(120);
    JButton search = new JButton("Cari");
    JButton bayar = new JButton("Bayar");
    JButton keluar = new JButton("Keluar");

    View(String role, String name){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Kasir");
        setLayout(null);

//        *bagian panel atas
        kasir = new JLabel("Welcome "+role);
        kasir.setFont(new Font("Verdana",Font.PLAIN,22));
        kasir.setForeground(Color.white);

        DateFormat dateFormat = new SimpleDateFormat("EEEE, MMMMM dd, yyyy");
        Date date = new Date();
        ldate = new JLabel(dateFormat.format(date),JLabel.RIGHT);
        ldate.setFont(new Font("Verdana",Font.BOLD,14));
        Timer time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ltime.setText(new SimpleDateFormat("HH.mm.ss").format(new java.util.Date())+" WIB");
            }
        },0,1000);
        ltime.setOpaque(false);
        ltime.setBorder(null);
        ltime.setFont(new Font("Verdana",Font.BOLD,14));
        ltime.setHorizontalAlignment(JTextField.RIGHT);

//        *Bagian panel ke 2
        lname = new JLabel("Nama");
        lno = new JLabel("No Transaksi");
        lcari = new JLabel("Kode Barang");
        fname = new JLabel(name);
        fno = new JLabel("0");
        lname.setFont(new Font("Verdana",Font.BOLD,14));
        lno.setFont(new Font("Verdana",Font.BOLD,14));
        lcari.setFont(new Font("Verdana",Font.BOLD,14));
        fname.setFont(new Font("Verdana",Font.BOLD,14));
        fno.setFont(new Font("Verdana",Font.BOLD,14));

        jPanel1.setLayout(null);
        jPanel1.add(lname);
        jPanel1.add(lno);
        jPanel1.add(fname);
        jPanel1.add(fno);
        jPanel1.add(lcari);
        jPanel1.add(fcari);
        jPanel1.add(search);

        lname.setBounds(10,10,180,30);
        lno.setBounds(10,40,180,30);
        fname.setBounds(200,10,180,30);
        fno.setBounds(200,40,180,30);
        lcari.setBounds(10,80,180,30);
        fcari.setBounds(200,80,200,30);
        search.setBounds(420,80,100,30);

//        *Set panel atas
        jPanel.setLayout(null);
        jPanel.add(kasir);
        jPanel.add(ldate);
        jPanel.add(ltime);

//        *Bagian tabel
        String[] column = {"Kode","Nama Barang","Qty","Satuan","Harga","Disc","Subtotal"};
        DefaultTableModel tableModel = new DefaultTableModel(column,1);
        JTable table = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);

//        *Setting tabel
        DefaultTableCellRenderer righttable = new DefaultTableCellRenderer();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(20);
        table.setFont(new Font("SansSerif",Font.PLAIN,14));
        table.getColumnModel().getColumn(0).setPreferredWidth(235);
        table.getColumnModel().getColumn(1).setPreferredWidth(547);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(250);
        righttable.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(2).setCellRenderer(righttable);
        table.getColumnModel().getColumn(4).setCellRenderer(righttable);
        table.getColumnModel().getColumn(5).setCellRenderer(righttable);
        table.getColumnModel().getColumn(6).setCellRenderer(righttable);

//        *Tambahan ke frame
        total.setSize(200,200);
        total.setFont(new Font("SansSerif",Font.PLAIN,90));
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        total.setEditable(false);
        total.setBorder(null);

//        *Setting panel 2
        alamat = new JLabel("Jl. Tambak Bayan");
        alamat.setFont(new Font("SansSerif",Font.PLAIN,90));
        alamat.setForeground(Color.gray);

        jPanel2.setLayout(null);
        jPanel2.add(bayar);
        jPanel2.add(keluar);
        jPanel2.add(alamat);

        bayar.setBounds(1200,20,120,30);
        keluar.setBounds(1350,20,120,30);
        alamat.setBounds(20,50,1000,120);

        add(jPanel);
        add(jPanel1);
        add(jPanel2);
        add(jScrollPane);
        add(total);


        kasir.setBounds(20,20,1000,40);
        ldate.setBounds(1320,5,200,40);
        ltime.setBounds(1320,25,200,40);

        jPanel.setBounds(0,0,1536,80);
        jPanel1.setBounds(0,130,1536,120);
        jPanel2.setBounds(0,662,1536,180);
        jScrollPane.setBounds(2,250,1536,300);
        total.setBounds(20,560,1500,80);
    }
}

class checkQty extends JFrame{
    checkQty(){
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setTitle("Detai barang");
        setLayout(null);
    }
}

class jPanelGradient extends JPanel{
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        Color color1 = new Color(52,143,80);
        Color color2 = new Color(86,180,211);
        GradientPaint gp = new GradientPaint(0,0,color1,180,400,color2);
        g2d.setPaint(gp);
        g2d.fillRect(0,0,width,height);
    }
}