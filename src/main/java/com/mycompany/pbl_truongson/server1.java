package com.mycompany.pbl_truongson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class server1 extends javax.swing.JFrame implements Runnable{


  public static ServerSocket serverSocket;
  public static DefaultListModel model;
    public static Socket socket;
   public static  ArrayList<Socket> listSK;
   
    public server1() {
        initComponents();
       model= new DefaultListModel();
     
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnsend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtport = new javax.swing.JTextField();
        btnstart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsDAngcho = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsHistory = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMessages = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btndongbo = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lsDongbo1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnsend.setBackground(new java.awt.Color(153, 255, 102));
        btnsend.setText("SEND");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("PORT NO.");

        txtport.setText("8888");
        txtport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtportActionPerformed(evt);
            }
        });

        btnstart.setBackground(new java.awt.Color(255, 255, 51));
        btnstart.setText("Start");
        btnstart.setToolTipText("");
        btnstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstartActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("SERVER");

        jScrollPane1.setViewportView(lsDAngcho);

        lsHistory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lsHistory);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Danh sach Client đang chờ");

        txtMessages.setColumns(20);
        txtMessages.setRows(5);
        jScrollPane4.setViewportView(txtMessages);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("MESSENGER");

        btndongbo.setBackground(new java.awt.Color(255, 255, 51));
        btndongbo.setText("Đồng bộ");
        btndongbo.setToolTipText("");
        btndongbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndongboActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(lsDongbo1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnstart)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnsend, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btndongbo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(247, 247, 247))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addGap(317, 317, 317)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnstart))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(186, 186, 186)))
                .addComponent(btndongbo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsend, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(365, Short.MAX_VALUE)))
        );

        pack();
    }

    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed
        
        System.out.println("SEEENT");

           String sms= txtMessages.getText();
                model.addElement("Server:"+sms);
                
                    lsDAngcho.setModel(model);
                    lsHistory.setModel(model);
          
           try {
                 for(Socket item:listSK)
               {
                	 Thread tr = new Thread(
                			 ()->guitinnhan(item,sms)
                			 ); 
                	 tr.start();
               }
           } catch (Exception e) {
           }      
    }
    
    private static void guitinnhan(Socket item, String sms) {
        DataOutputStream dos;
        try {
			dos= new DataOutputStream(item.getOutputStream());
		       dos.writeUTF("SERVERSAY :"+sms);
		       dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    private void txtportActionPerformed(java.awt.event.ActionEvent evt) {   
    }

    private void btnstartActionPerformed(java.awt.event.ActionEvent evt) {
        }

    private void btndongboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndongboActionPerformed
      
    }

  
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	try {
					new Thread(new server1()).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }
    private javax.swing.JButton btndongbo;
    private javax.swing.JButton btnsend;
    private javax.swing.JButton btnstart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private static javax.swing.JList<String> lsDAngcho;
    private javax.swing.JList<String> lsDongbo1;
    private static javax.swing.JList<String> lsHistory;
    private javax.swing.JTextArea txtMessages;
    private javax.swing.JTextField txtport;
    
 class ReadServer extends  Thread{
      private Socket socket;
    public ReadServer(Socket socket)
    {
        this.socket=socket;
    }
    @Override
    public void run()
    {
        DataInputStream dis=null;
        try {
            
            dis=new DataInputStream(socket.getInputStream());
            while (true) {                
              String sms=  dis.readUTF();
                 model.addElement(sms);
                lsHistory.setModel(model);
               
                System.out.println(sms);
                  
                if(sms.contains("exit"))
                {
                	server1.listSK.remove(socket);
                    
                     model.addElement("DA ngat ket noi voi"+socket);
                        lsHistory.setModel(model);
                        
                    dis.close();
                    socket.close();
                    continue;
                }

            }
            
        
        } catch (Exception e) {
            try {
                 dis.close();
            socket.close();
            } catch (IOException  ex) {
                
            }
        }
    }
 }


class WriteServer extends Thread{
   
    @Override
    public void run()
    {
        
        DataOutputStream dos=null;
       
       while(true)
       {
           String sms= txtMessages.getText();
           try {
                 for(Socket item:server1.listSK)
               {
                    dos= new DataOutputStream(item.getOutputStream());
                   dos.writeUTF("SERVERSAY :"+sms);
                   dos.flush();
               }
           } catch (Exception e) {
           }
       }
    }
    }


@Override
public void run() {

	listSK=new ArrayList<>();
   this.setVisible(true);
   try
   {
	   serverSocket = new ServerSocket(Integer.parseInt(txtport.getText()));
       System.out.println("Conecting..");
//	   Socket socket;
       while (true) {   
    	   System.out.println("dang cho ket noi");
		    try {
       	Socket socket= serverSocket.accept(); 
			model.addElement("Server is connected"+socket);
          // lsDAngcho.setModel(model);
           lsHistory.setModel(model);                                    
  System.out.println("SERVER DA KET NOI");                            
  listSK.add(socket);                
  System.out.println(listSK.size()); 
  ReadServer rs= new ReadServer(socket);
  rs.start();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
           
}     
   } catch (IOException e1) {
	e1.printStackTrace();
}                                      
} 
}
 
