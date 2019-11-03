
package dataaccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 784564
 */
public class DBUtil
  {
        private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("NotePU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
  }
