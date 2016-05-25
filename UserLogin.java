package Terminal;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.im.InputContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserLogin extends javax.swing.JFrame 
                       implements LanguageSettings{
    
    LangChoice lang = new LangChoice();
    DBConnection dataBase = new DBConnection();
    ArrayList<ArrayList<String>> users;
    ResourceBundle resource = null;
    Locale locale;
    Departure departureTable;
    Point position;
    
    public static String CURRENT_USER_NAME;

    public UserLogin() {
        //lang.setVisible(true);

        initComponents();
        initEngInputLocale();
        applyLanguage();
        hideInitPanels();
        applyFieldConstr();
        applyMouseDrag();
        //setVisible(true);
    }

    @Override
    public void applyLanguage(){
        if(LangChoice.LANG_MODE)
            locale = new Locale("ru", "RU");
        else
            locale = Locale.US;
        
        resource = ResourceBundle.getBundle("Properties/UserLoginSUPER", locale);
        changeLabels();
    }
    @Override
    public void changeLabels(){
        pastBuyBut.setText(resource.getString("UserLogin.pastBuyUser.text"));
        newBuyBut.setText(resource.getString("UserLogin.newBuyBut.text"));
        regLabel.setText(resource.getString("UserLogin.regLabel.text"));
        nameLabel.setText(resource.getString("UserLogin.nameLabel.text"));
        surnameLabel.setText(resource.getString("UserLogin.surnameLabel.text"));
        passwordLabel.setText(resource.getString("UserLogin.passwordLabel.text"));
        repPasswordLabel.setText(resource.getString("UserLogin.repPasswordLabel.text"));
        subLabel.setText(resource.getString("UserLogin.subLabel.text"));
        passportLabel.setText(resource.getString("UserLogin.passportLabel.text"));
        regButton.setText(resource.getString("UserLogin.regBut.text"));
        upCaseInfo1.setText(resource.getString("UserLogin.upCaseInfo1.text"));
        upCaseInfo3.setText(resource.getString("UserLogin.upCaseInfo1.text"));
        authName.setText(resource.getString("UserLogin.authName.text"));
        authPassLabel.setText(resource.getString("UserLogin.authPassLabel.text"));
        logInBut.setText(resource.getString("UserLogin.logInBut.text"));
        authLabel.setText(resource.getString("UserLogin.authLabel.text"));
        upCaseInfo2.setText(resource.getString("UserLogin.upCaseInfo2.text"));
    }
    
    private void hideInitPanels() {
        authPanel.setVisible(false);
        regPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layeredPane = new javax.swing.JLayeredPane();
        choicePanel = new javax.swing.JPanel();
        exitBut = new javax.swing.JButton();
        adminModeBut = new javax.swing.JButton();
        backFrameBut = new javax.swing.JButton();
        pastBuyBut = new javax.swing.JButton();
        newBuyBut = new javax.swing.JButton();
        regPanel = new javax.swing.JPanel();
        regLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        repPasswordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        repPasswordField = new javax.swing.JPasswordField();
        subLabel = new javax.swing.JLabel();
        passportLabel = new javax.swing.JLabel();
        passportField = new javax.swing.JTextField();
        regButton = new javax.swing.JButton();
        upCaseInfo1 = new javax.swing.JLabel();
        upCaseInfo3 = new javax.swing.JLabel();
        authPanel = new javax.swing.JPanel();
        authNameField = new javax.swing.JTextField();
        authName = new javax.swing.JLabel();
        authPassLabel = new javax.swing.JLabel();
        logInBut = new javax.swing.JButton();
        authLabel = new javax.swing.JLabel();
        authPassField = new javax.swing.JPasswordField();
        upCaseInfo2 = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choicePanel.setOpaque(false);

        exitBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        exitBut.setContentAreaFilled(false);
        exitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButActionPerformed(evt);
            }
        });

        adminModeBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adminMode.png"))); // NOI18N
        adminModeBut.setContentAreaFilled(false);
        adminModeBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminModeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminModeButActionPerformed(evt);
            }
        });

        backFrameBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backBut.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Properties/UserLogin"); // NOI18N
        backFrameBut.setToolTipText(bundle.getString("ВЕРНУТЬСЯ К ВЫБОРУ ЯЗЫКА")); // NOI18N
        backFrameBut.setContentAreaFilled(false);
        backFrameBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFrameButActionPerformed(evt);
            }
        });

        pastBuyBut.setBackground(new java.awt.Color(102, 216, 202));
        pastBuyBut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pastBuyBut.setForeground(new java.awt.Color(255, 255, 255));
        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("Properties/UserLogin_ru_RU"); // NOI18N
        pastBuyBut.setText(bundle1.getString("УЖЕ ПОКУПАЛ(-А) БИЛЕТ")); // NOI18N
        pastBuyBut.setActionCommand("");
        pastBuyBut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pastBuyBut.setContentAreaFilled(false);
        pastBuyBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pastBuyBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pastBuyButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pastBuyButMouseExited(evt);
            }
        });
        pastBuyBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastBuyButActionPerformed(evt);
            }
        });

        newBuyBut.setBackground(new java.awt.Color(102, 216, 202));
        newBuyBut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newBuyBut.setForeground(new java.awt.Color(255, 255, 255));
        newBuyBut.setText(bundle1.getString("НОВЫЙ ПОЛЬЗОВАТЕЛЬ")); // NOI18N
        newBuyBut.setActionCommand("");
        newBuyBut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        newBuyBut.setContentAreaFilled(false);
        newBuyBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newBuyBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBuyButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newBuyButMouseExited(evt);
            }
        });
        newBuyBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBuyButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout choicePanelLayout = new javax.swing.GroupLayout(choicePanel);
        choicePanel.setLayout(choicePanelLayout);
        choicePanelLayout.setHorizontalGroup(
            choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choicePanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pastBuyBut, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(newBuyBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 407, Short.MAX_VALUE))
            .addGroup(choicePanelLayout.createSequentialGroup()
                .addGroup(choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(backFrameBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, choicePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(adminModeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        choicePanelLayout.setVerticalGroup(
            choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choicePanelLayout.createSequentialGroup()
                .addGroup(choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backFrameBut)
                    .addComponent(exitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addComponent(pastBuyBut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newBuyBut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(adminModeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        regPanel.setOpaque(false);

        regLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        regLabel.setForeground(new java.awt.Color(255, 255, 255));
        regLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regLabel.setText(bundle1.getString("РЕГИСТРАЦИЯ")); // NOI18N

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameLabel.setText(bundle1.getString("ВВЕДИТЕ ИМЯ:")); // NOI18N

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        surnameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        surnameLabel.setText(bundle1.getString("ВВЕДИТЕ ФАМИЛИЮ:")); // NOI18N

        surnameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passwordLabel.setText(bundle1.getString("ВАШ ПАРОЛЬ:")); // NOI18N

        repPasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        repPasswordLabel.setText(bundle1.getString("ПОВТОРИТЕ ПАРОЛЬ:")); // NOI18N

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        repPasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        repPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                repPasswordFieldFocusGained(evt);
            }
        });

        subLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        subLabel.setForeground(new java.awt.Color(255, 255, 255));
        subLabel.setText(bundle1.getString("*ВСЕ ДАННЫЕ ЛАТИНИЦЕЙ")); // NOI18N

        passportLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passportLabel.setText(bundle1.getString("КОД ПАСПОРТА:")); // NOI18N

        passportField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passportField.setToolTipText(bundle.getString("ФОРМАТ: AA000000")); // NOI18N
        passportField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passportFieldFocusGained(evt);
            }
        });

        regButton.setBackground(new java.awt.Color(102, 216, 202));
        regButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regButton.setForeground(new java.awt.Color(255, 255, 255));
        regButton.setText(bundle.getString("ЗАРЕГИСТРИРОВАТЬСЯ")); // NOI18N
        regButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        regButton.setContentAreaFilled(false);
        regButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regButtonMouseExited(evt);
            }
        });
        regButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regButtonActionPerformed(evt);
            }
        });

        upCaseInfo1.setForeground(new java.awt.Color(255, 0, 0));
        upCaseInfo1.setText(bundle1.getString("ЗАГЛАВНЫЕ БУКВЫ!")); // NOI18N

        upCaseInfo3.setForeground(new java.awt.Color(255, 0, 0));
        upCaseInfo3.setText(bundle1.getString("ЗАГЛАВНЫЕ БУКВЫ!_1")); // NOI18N

        javax.swing.GroupLayout regPanelLayout = new javax.swing.GroupLayout(regPanel);
        regPanel.setLayout(regPanelLayout);
        regPanelLayout.setHorizontalGroup(
            regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, regPanelLayout.createSequentialGroup()
                        .addComponent(regLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(regPanelLayout.createSequentialGroup()
                        .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(regPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(subLabel)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, regPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(regPanelLayout.createSequentialGroup()
                                        .addComponent(nameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(upCaseInfo1))
                                    .addGroup(regPanelLayout.createSequentialGroup()
                                        .addComponent(surnameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(upCaseInfo3))
                                    .addGroup(regPanelLayout.createSequentialGroup()
                                        .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(passwordField)
                                            .addComponent(passportField)
                                            .addComponent(surnameField)
                                            .addComponent(repPasswordField)
                                            .addComponent(nameField)
                                            .addComponent(regButton, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                            .addComponent(repPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(passportLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18))))
        );
        regPanelLayout.setVerticalGroup(
            regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regPanelLayout.createSequentialGroup()
                .addComponent(regLabel)
                .addGap(4, 4, 4)
                .addComponent(subLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(upCaseInfo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLabel)
                    .addComponent(upCaseInfo3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passportLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passportField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(regButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        regLabel.getAccessibleContext().setAccessibleName("null");
        nameLabel.getAccessibleContext().setAccessibleName("null");
        surnameLabel.getAccessibleContext().setAccessibleName("null");
        passwordLabel.getAccessibleContext().setAccessibleName("null");
        repPasswordLabel.getAccessibleContext().setAccessibleName("null");
        subLabel.getAccessibleContext().setAccessibleName("null");
        passportLabel.getAccessibleContext().setAccessibleName("null");
        upCaseInfo1.getAccessibleContext().setAccessibleName("null");
        upCaseInfo3.getAccessibleContext().setAccessibleName("null");

        authPanel.setBackground(new java.awt.Color(193, 205, 220));
        authPanel.setOpaque(false);

        authNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        authNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                authNameFieldFocusGained(evt);
            }
        });

        authName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        authName.setText(bundle1.getString("ВВЕДИТЕ ИМЯ И ФАМИЛИЮ:")); // NOI18N

        authPassLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        authPassLabel.setText(bundle1.getString("ВВЕДИТЕ ЛИЧНЫЙ ПАРОЛЬ:")); // NOI18N

        logInBut.setBackground(new java.awt.Color(102, 216, 202));
        logInBut.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        logInBut.setForeground(new java.awt.Color(255, 255, 255));
        logInBut.setText(bundle1.getString("ВОЙТИ")); // NOI18N
        logInBut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        logInBut.setContentAreaFilled(false);
        logInBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logInButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logInButMouseExited(evt);
            }
        });
        logInBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButActionPerformed(evt);
            }
        });

        authLabel.setBackground(new java.awt.Color(206, 231, 246));
        authLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        authLabel.setForeground(new java.awt.Color(255, 255, 255));
        authLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authLabel.setText(bundle1.getString("АВТОРИЗАЦИЯ")); // NOI18N

        authPassField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        authPassField.setForeground(new java.awt.Color(51, 51, 255));
        authPassField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                authPassFieldFocusGained(evt);
            }
        });

        upCaseInfo2.setForeground(new java.awt.Color(255, 0, 0));
        upCaseInfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        upCaseInfo2.setText(bundle1.getString("ЗАГЛАВНЫЕ БУКВЫ!")); // NOI18N

        javax.swing.GroupLayout authPanelLayout = new javax.swing.GroupLayout(authPanel);
        authPanel.setLayout(authPanelLayout);
        authPanelLayout.setHorizontalGroup(
            authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authPanelLayout.createSequentialGroup()
                .addGroup(authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(authPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(authLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(authPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(authNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(authPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(authPassLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(authName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(upCaseInfo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(authPanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(logInBut, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        authPanelLayout.setVerticalGroup(
            authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authPanelLayout.createSequentialGroup()
                .addComponent(authLabel)
                .addGap(61, 61, 61)
                .addComponent(upCaseInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(authPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logInBut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        authName.getAccessibleContext().setAccessibleName("null");
        authPassLabel.getAccessibleContext().setAccessibleName("null");
        logInBut.getAccessibleContext().setAccessibleName("null");
        authLabel.getAccessibleContext().setAccessibleName("null");

        layeredPane.setLayer(choicePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(regPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(authPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredPaneLayout = new javax.swing.GroupLayout(layeredPane);
        layeredPane.setLayout(layeredPaneLayout);
        layeredPaneLayout.setHorizontalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPaneLayout.createSequentialGroup()
                    .addGap(0, 353, Short.MAX_VALUE)
                    .addComponent(authPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPaneLayout.createSequentialGroup()
                    .addGap(0, 360, Short.MAX_VALUE)
                    .addComponent(regPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layeredPaneLayout.setVerticalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(authPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(regPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(layeredPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 390));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initEngInputLocale() {
        InputContext currentInputContext = this.getContentPane().getInputContext();
        currentInputContext.selectInputMethod(new Locale("EN", "US"));
    }

    private void pastBuyButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastBuyButActionPerformed
        showAuthPanel();
    }//GEN-LAST:event_pastBuyButActionPerformed

    private void newBuyButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBuyButActionPerformed
        showRegPanel();
    }//GEN-LAST:event_newBuyButActionPerformed

    private void adminModeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminModeButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminModeButActionPerformed

    private void logInButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButActionPerformed

        try {
            this.users = dataBase.getUserList();
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        int usersCount = users.size();
        String name, surname, password;
        String inputName = authNameField.getText();
        String inputPass = authPassField.getText();
        int keyUser = 0;
        for (int i = 0; i < usersCount; i++) {
            name = users.get(i).get(0);
            surname = users.get(i).get(1);
            if (inputName.equals(name + ' ' + surname) || (inputName.equals(surname + ' ' + name))) {
                authNameField.setBackground(new Color(255, 255, 255));
                keyUser = i;
                CURRENT_USER_NAME = name + ' ' + surname;
                break;
            } else {
                authNameField.setBackground(new Color(255, 45, 35));
            }
        }

        password = users.get(keyUser).get(2);
        if (!inputPass.equals(password)) {
            authPassField.setBackground(new Color(255, 45, 35));
            return;
        }

        emptyRegFields();

        try {
            showDepartureTable();
        } catch (SQLException | InterruptedException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logInButActionPerformed

    private void showDepartureTable() throws SQLException, InterruptedException {
        departureTable = new Departure();
        departureTable.setVisible(true);
        this.setVisible(false);
    }

    private void backFrameButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backFrameButActionPerformed
        dispose();
        lang.setVisible(true);
    }//GEN-LAST:event_backFrameButActionPerformed

    private void regButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButtonActionPerformed
        try {
            String name = nameField.getText().trim();
            String surname = surnameField.getText().trim();
            String passport = passportField.getText();
            String password = passwordField.getText();
            String repPassword = repPasswordField.getText();

            if (name.isEmpty() || surname.isEmpty()) {
                JOptionPane.showMessageDialog(layeredPane, "НЕПРАВИЛЬНО ВВЕДЕНЫ ИМЯ ИЛИ ФАМИЛИЯ!", "ОШИБКА ВВОДА", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!checkPassport(passport)) {
                passportField.setBackground(new Color(255, 45, 35));
                return;
            }

            if (password.isEmpty() || !password.equals(repPassword)) {
                repPasswordField.setBackground(new Color(255, 45, 35));
                return;
            }

            dataBase.addUser(name, surname, password, passport);

            JOptionPane.showMessageDialog(layeredPane, "УСПЕШНО ЗАРЕГИСТРИРОВАН!", "ВЫПОЛНЕНО", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/images/ok.png"));
            showAuthPanel();
            emptyRegFields();

        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(layeredPane, "ПОЛЬЗОВАТЕЛЬ С ТАКИМ НОМЕРОМ ПАСПОРТА УЖЕ ЗАРЕГИСТРИРОВАН", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_regButtonActionPerformed

    private void passportFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passportFieldFocusGained
        passportField.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_passportFieldFocusGained

    private void repPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repPasswordFieldFocusGained
        repPasswordField.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_repPasswordFieldFocusGained

    private void authNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_authNameFieldFocusGained
        authNameField.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_authNameFieldFocusGained

    private void authPassFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_authPassFieldFocusGained
        authPassField.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_authPassFieldFocusGained

    private void exitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButActionPerformed
        if (JOptionPane.showConfirmDialog(this, "ARE YOU SURE TO EXIT?", "CONFIRM EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitButActionPerformed

    private void pastBuyButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pastBuyButMouseEntered
        pastBuyBut.setOpaque(true);
    }//GEN-LAST:event_pastBuyButMouseEntered

    private void pastBuyButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pastBuyButMouseExited
        pastBuyBut.setOpaque(false);
    }//GEN-LAST:event_pastBuyButMouseExited

    private void newBuyButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBuyButMouseEntered
        newBuyBut.setOpaque(true);
    }//GEN-LAST:event_newBuyButMouseEntered

    private void newBuyButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBuyButMouseExited
        newBuyBut.setOpaque(false);
    }//GEN-LAST:event_newBuyButMouseExited

    private void regButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regButtonMouseEntered
        regButton.setOpaque(true);
    }//GEN-LAST:event_regButtonMouseEntered

    private void regButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regButtonMouseExited
        regButton.setOpaque(false);
    }//GEN-LAST:event_regButtonMouseExited

    private void logInButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButMouseEntered
        logInBut.setOpaque(true);
    }//GEN-LAST:event_logInButMouseEntered

    private void logInButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButMouseExited
        logInBut.setOpaque(false);
    }//GEN-LAST:event_logInButMouseExited

    private void applyFieldConstr() {
        authNameField.setDocument(new LetterConstraint());

        nameField.setDocument(new LetterConstraint());
        surnameField.setDocument(new LetterConstraint());
    }

    private void showAuthPanel() {
        layeredPane.setPosition(regPanel, -1);
        layeredPane.setPosition(authPanel, 0);
        regPanel.setVisible(false);
        authPanel.setVisible(true);
    }

    private void showRegPanel() {
        layeredPane.setPosition(authPanel, -1);
        layeredPane.setPosition(regPanel, 0);
        authPanel.setVisible(false);
        regPanel.setVisible(true);
    }

    private void emptyRegFields() {
        nameField.setText("");
        surnameField.setText("");
        passportField.setText("");
        passwordField.setText("");
        repPasswordField.setText("");

        authNameField.setText("");
        authPassField.setText("");
    }

    public boolean checkPassport(String text) {
        Pattern patt = Pattern.compile("^[A-Z]{2}[0-9]{6}$");
        Matcher match = patt.matcher(text);
        return match.matches();
    }

    private void applyMouseDrag() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                position = e.getPoint();
                getComponentAt(position);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //old position
                int thisX = (int) getLocation().getX();
                int thisY = (int) getLocation().getY();
                //new position
                int xMoved = thisX + (e.getX() - position.x);
                int yMoved = thisY + (e.getY() - position.y);

                setLocation(xMoved, yMoved);
            }
        });
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (("NIMBUS").equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        java.awt.EventQueue.invokeLater(()->{
//                new UserLogin().setVisible(true);
//        });        //</editor-fold>

//        java.awt.EventQueue.invokeLater(()->{
//                new UserLogin().setVisible(true);
//        });        //</editor-fold>

//        java.awt.EventQueue.invokeLater(()->{
//                new UserLogin().setVisible(true);
//        });        //</editor-fold>

//        java.awt.EventQueue.invokeLater(()->{
//                new UserLogin().setVisible(true);
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminModeBut;
    private javax.swing.JLabel authLabel;
    private javax.swing.JLabel authName;
    private javax.swing.JTextField authNameField;
    private javax.swing.JPanel authPanel;
    private javax.swing.JPasswordField authPassField;
    private javax.swing.JLabel authPassLabel;
    private javax.swing.JButton backFrameBut;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel choicePanel;
    private javax.swing.JButton exitBut;
    private javax.swing.JLayeredPane layeredPane;
    private javax.swing.JButton logInBut;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newBuyBut;
    private javax.swing.JTextField passportField;
    private javax.swing.JLabel passportLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton pastBuyBut;
    private javax.swing.JButton regButton;
    private javax.swing.JLabel regLabel;
    private javax.swing.JPanel regPanel;
    private javax.swing.JPasswordField repPasswordField;
    private javax.swing.JLabel repPasswordLabel;
    private javax.swing.JLabel subLabel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel upCaseInfo1;
    private javax.swing.JLabel upCaseInfo2;
    private javax.swing.JLabel upCaseInfo3;
    // End of variables declaration//GEN-END:variables
}

