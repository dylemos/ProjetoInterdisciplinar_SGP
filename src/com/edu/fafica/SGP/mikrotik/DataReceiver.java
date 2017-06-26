package com.edu.fafica.SGP.mikrotik;

import libAPI.*;
import libAPI.ApiConn;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janisk
 */
public class DataReceiver extends Thread {

  private ApiConn aConn = null;
  T3apiView t3A = null;

  public DataReceiver(ApiConn aConn, T3apiView t3A) {
      this.aConn = aConn;
      this.t3A = t3A;
  }

  @Override
  public void run() {
      String s = "";
      while (true) {
          try {
              s = aConn.getData();
              if (s != null) {
                  t3A.outputHere(s);
                  if (s.contains("!done")) {
                  }
              }
          } catch (InterruptedException ex) {
              Logger.getLogger(DataReceiver.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
  }
}