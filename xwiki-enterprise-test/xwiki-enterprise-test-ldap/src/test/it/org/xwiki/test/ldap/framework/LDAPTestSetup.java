/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.test.ldap.framework;

import java.util.HashSet;
import java.util.Set;

import junit.extensions.TestSetup;
import junit.framework.Test;

/**
 * JUnit TestSetup extension that starts/stops embedded LDAP server. This class is meant to wrap a JUnit TestSuite. For
 * example:
 * 
 * <pre>
 * &lt;code&gt;
 * public static Test suite()
 * {
 *     // Create some TestSuite object here
 *     return new LDAPTestSetup(suite);
 * }
 * &lt;/code&gt;
 * </pre>
 * 
 * @version $Id$
 */
public class LDAPTestSetup extends TestSetup
{
    public static final String LDAP_SERVER = "127.0.0.1";

    /**
     * The LDAP base DN from where to executes LDAP queries.
     */
    public static final String LDAP_BASEDN = "o=sevenSeas";
    
    public static final String LDAP_BINDDN_CN = "cn={0},ou=people,o=sevenSeas";
    public static final String LDAP_BINDPASS_CN = "{1}";

    /**
     * The name of the LDAP property containing user unique id (cn).
     */
    public static final String LDAP_USERUID_FIELD = "cn";

    /**
     * The name of the LDAP property containing user unique id (uid).
     */
    public static final String LDAP_USERUID_FIELD_UID = "uid";

    /**
     * The name of the system property containing the LDAP embedded server port.
     */
    public static final String SYSPROPNAME_LDAPPORT = "ldap_port";

    // Somes datas examples

    /**
     * The LDAP DN of user Horatio Hornblower.
     */
    public static final String HORATIOHORNBLOWER_DN = "cn=Horatio Hornblower,ou=people,o=sevenSeas";

    /**
     * The LDAP unique id of user Horatio Hornblower.
     */
    public static final String HORATIOHORNBLOWER_CN = "Horatio Hornblower";

    /**
     * The LDAP password of user Horatio Hornblower.
     */
    public static final String HORATIOHORNBLOWER_PWD = "pass";
    
    /**
     * The value of the LDAP sn for user Horatio Hornblower.
     */
    public static final String HORATIOHORNBLOWER_SN = "Hornblower";
    
    /**
     * The value of the LDAP givenName for user Horatio Hornblower.
     */
    public static final String HORATIOHORNBLOWER_GIVENNAME = "Horatio";
    
    /**
     * The value of the LDAP mail for user Horatio Hornblower.
     */
    public static final String HORATIOHORNBLOWER_MAIL = "hhornblo@royalnavy.mod.uk";

    /**
     * The LDAP DN of user Thomas Quist.
     */
    public static final String THOMASQUIST_DN = "cn=Thomas Quist,ou=people,o=sevenSeas";

    /**
     * The LDAP common name of user Thomas Quist.
     */
    public static final String THOMASQUIST_CN = "Thomas Quist";

    /**
     * The LDAP password of user Thomas Quist.
     */
    public static final String THOMASQUIST_PWD = "pass";

    /**
     * The LDAP DN of user William Bush.
     */
    public static final String WILLIAMBUSH_DN = "cn=William Bush,ou=people,o=sevenSeas";

    /**
     * The LDAP password of user William Bush.
     */
    public static final String WILLIAMBUSH_PWD = "pass";

    /**
     * The LDAP unique id of user William Bush.
     */
    public static final String WILLIAMBUSH_UID = "wbush";

    /**
     * The LDAP unique id with mixed case of user William Bush.
     */
    public static final String WILLIAMBUSH_UID_MIXED = "wBush";

    /**
     * The LDAP DN of user User.With.Points.
     */
    public static final String USERWITHPOINTS_DN = "cn=User.With.Points,ou=people,o=sevenSeas";

    /**
     * The LDAP password of user User.With.Points.
     */
    public static final String USERWITHPOINTS_PWD = "pass";

    /**
     * The LDAP common name of user User.With.Points.
     */
    public static final String USERWITHPOINTS_CN = "User.With.Points";
    
    /**
     * The LDAP unique id of user User.With.Points.
     */
    public static final String USERWITHPOINTS_UID = "user.with.points";
    
    /**
     * The LDAP DN of user User.WithPoints.
     */
    public static final String OTHERUSERWITHPOINTS_DN = "cn=User.WithPoints,ou=people,o=sevenSeas";

    /**
     * The LDAP password of user User.WithPoints.
     */
    public static final String OTHERUSERWITHPOINTS_PWD = "pass";

    /**
     * The LDAP common name of user User.WithPoints.
     */
    public static final String OTHERUSERWITHPOINTS_CN = "User.WithPoints";
    
    /**
     * The LDAP unique id of user User.WithPoints.
     */
    public static final String OTHERUSERWITHPOINTS_UID = "user.withpoints";

    /**
     * The LDAP DN of group HMS Lydia.
     */
    public static final String HMSLYDIA_DN = "cn=HMS Lydia,ou=crews,ou=groups,o=sevenSeas";

    /**
     * The LDAP DN of group to exclude from login.
     */
    public static final String EXCLUSIONGROUP_DN = "cn=Exlude Group,ou=crews,ou=groups,o=sevenSeas";

    /**
     * The LDAP members of group HMS Lydia.
     */
    public static final Set<String> HMSLYDIA_MEMBERS = new HashSet<String>();

    static {
        HMSLYDIA_MEMBERS.add(HORATIOHORNBLOWER_DN.toLowerCase());
        HMSLYDIA_MEMBERS.add(WILLIAMBUSH_DN.toLowerCase());
        HMSLYDIA_MEMBERS.add("cn=Thomas Quist,ou=people,o=sevenSeas".toLowerCase());
        HMSLYDIA_MEMBERS.add("cn=Moultrie Crystal,ou=people,o=sevenSeas".toLowerCase());
        HMSLYDIA_MEMBERS.add("cn=User.With.Points,ou=people,o=sevenSeas".toLowerCase());
    }

    // ///

    /**
     * Tool to start and stop embedded LDAP server.
     */
    private LDAPRunner ldap = new LDAPRunner();

    public LDAPTestSetup(Test test)
    {
        super(test);
    }

    /**
     * @return return the port of the current instance of LDAP server.
     */
    public static int getLDAPPort()
    {
        return Integer.parseInt(System.getProperty(SYSPROPNAME_LDAPPORT));
    }

    @Override
    protected void setUp() throws Exception
    {
        this.ldap.start();

        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();

        this.ldap.stop();
    }
}
