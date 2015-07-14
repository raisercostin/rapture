/******************************************************************************************************************\
* Rapture Net, version 2.0.0. Copyright 2010-2015 Jon Pretty, Propensive Ltd.                                      *
*                                                                                                                  *
* The primary distribution site is http://rapture.io/                                                              *
*                                                                                                                  *
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in complance    *
* with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.            *
*                                                                                                                  *
* Unless required by applicable law or agreed to in writing, software distributed under the License is distributed *
* on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License    *
* for the specific language governing permissions and limitations under the License.                               *
\******************************************************************************************************************/
package rapture.net
import rapture.core._
  
/** Provides a typesafe list of network services mapping from port number to service name.  This
  * is based on [http://www.iana.org/assignments/port-numbers] and
  * [http://www.freebsd.org/cgi/cvsweb.cgi/src/etc/services] */
object services {
  object tcp {

    private lazy val serviceNames: Map[String, Port] =
      enumerateMembers[Port](this).map { p => p.name -> p }.toMap

    def apply(name: String) = serviceNames(name)

    case class Port(portNo: Int)(implicit assigned: AssignedName) { def name = assigned.name }
    
    val tcpmux = Port(1)
    val compressnet = Port(2)
    val compressnet2 = Port(3)
    val rje = Port(5)
    val echo = Port(7)
    val discard = Port(9)
    val systat = Port(11)
    val daytime = Port(13)
    val qotd = Port(17)
    val msp = Port(18)
    val chargen = Port(19)
    val `ftp-data` = Port(20)
    val ftp = Port(21)
    val ssh = Port(22)
    val telnet = Port(23)
    val smtp = Port(25)
    val `nsw-fe` = Port(27)
    val `msg-icp` = Port(29)
    val `msg-auth` = Port(31)
    val dsp = Port(33)
    val time = Port(37)
    val rap = Port(38)
    val rlp = Port(39)
    val graphics = Port(41)
    val nameserver = Port(42)
    val nicname = Port(43)
    val `mpm-flags` = Port(44)
    val mpm = Port(45)
    val `mpm-snd` = Port(46)
    val `ni-ftp` = Port(47)
    val auditd = Port(48)
    val tacacs = Port(49)
    val `re-mail-ck` = Port(50)
    val domain = Port(53)
    val `xns-ch` = Port(54)
    val `isi-gl` = Port(55)
    val `xns-auth` = Port(56)
    val `xns-mail` = Port(58)
    val `ni-mail` = Port(61)
    val acas = Port(62)
    val `whois++` = Port(63)
    val covia = Port(64)
    val `tacacs-ds` = Port(65)
    val `sql*net` = Port(66)
    val bootps = Port(67)
    val bootpc = Port(68)
    val tftp = Port(69)
    val gopher = Port(70)
    val `netrjs-1` = Port(71)
    val `netrjs-2` = Port(72)
    val `netrjs-3` = Port(73)
    val `netrjs-4` = Port(74)
    val deos = Port(76)
    val vettcp = Port(78)
    val finger = Port(79)
    val http = Port(80)
    val `hosts2-ns` = Port(81)
    val xfer = Port(82)
    val `mit-ml-dev` = Port(83)
    val ctf = Port(84)
    val `mit-ml-dev2` = Port(85)
    val mfcobol = Port(86)
    val kerberos = Port(88)
    val `su-mit-tg` = Port(89)
    val dnsix = Port(90)
    val `mit-dov` = Port(91)
    val npp = Port(92)
    val dcp = Port(93)
    val objcall = Port(94)
    val supdup = Port(95)
    val dixie = Port(96)
    val `swift-rvf` = Port(97)
    val tacnews = Port(98)
    val metagram = Port(99)
    val hostname = Port(101)
    val `iso-tsap` = Port(102)
    val gppitnp = Port(103)
    val `acr-nema` = Port(104)
    val cso = Port(105)
    val `3com-tsmux` = Port(106)
    val rtelnet = Port(107)
    val snagas = Port(108)
    val pop2 = Port(109)
    val pop3 = Port(110)
    val sunrpc = Port(111)
    val mcidas = Port(112)
    val auth = Port(113)
    val sftp = Port(115)
    val ansanotify = Port(116)
    val `uucp-path` = Port(117)
    val sqlserv = Port(118)
    val nntp = Port(119)
    val cfdptkt = Port(120)
    val erpc = Port(121)
    val smakynet = Port(122)
    val ntp = Port(123)
    val ansatrader = Port(124)
    val `locus-map` = Port(125)
    val nxedit = Port(126)
    val `locus-con` = Port(127)
    val `gss-xlicen` = Port(128)
    val pwdgen = Port(129)
    val `cisco-fna` = Port(130)
    val `cisco-tna` = Port(131)
    val `cisco-sys` = Port(132)
    val statsrv = Port(133)
    val `ingres-net` = Port(134)
    val epmap = Port(135)
    val profile = Port(136)
    val `netbios-ns` = Port(137)
    val `netbios-dgm` = Port(138)
    val `netbios-ssn` = Port(139)
    val `emfis-data` = Port(140)
    val `emfis-cntl` = Port(141)
    val imap = Port(143)
    val uma = Port(144)
    val uaac = Port(145)
    val `iso-tp0` = Port(146)
    val `iso-ip` = Port(147)
    val jargon = Port(148)
    val `aed-512` = Port(149)
    val `sql-net` = Port(150)
    val hems = Port(151)
    val bftp = Port(152)
    val sgmp = Port(153)
    val `netsc-prod` = Port(154)
    val `netsc-dev` = Port(155)
    val sqlsrv = Port(156)
    val `knet-cmp` = Port(157)
    val `pcmail-srv` = Port(158)
    val `nss-routing` = Port(159)
    val `sgmp-traps` = Port(160)
    val snmp = Port(161)
    val snmptrap = Port(162)
    val `cmip-man` = Port(163)
    val `cmip-agent` = Port(164)
    val `xns-courier` = Port(165)
    val `s-net` = Port(166)
    val namp = Port(167)
    val rsvd = Port(168)
    val send = Port(169)
    val `print-srv` = Port(170)
    val multiplex = Port(171)
    val `xyplex-mux` = Port(173)
    val mailq = Port(174)
    val vmnet = Port(175)
    val `genrad-mux` = Port(176)
    val xdmcp = Port(177)
    val nextstep = Port(178)
    val bgp = Port(179)
    val ris = Port(180)
    val unify = Port(181)
    val audit = Port(182)
    val ocbinder = Port(183)
    val ocserver = Port(184)
    val `remote-kis` = Port(185)
    val kis = Port(186)
    val aci = Port(187)
    val mumps = Port(188)
    val qft = Port(189)
    val gacp = Port(190)
    val prospero = Port(191)
    val `osu-nms` = Port(192)
    val srmp = Port(193)
    val irc = Port(194)
    val `dn6-nlm-aud` = Port(195)
    val `dn6-smm-red` = Port(196)
    val dls = Port(197)
    val `dls-mon` = Port(198)
    val smux = Port(199)
    val src = Port(200)
    val `at-rtmp` = Port(201)
    val `at-nbp` = Port(202)
    val `at-echo` = Port(204)
    val `at-zis` = Port(206)
    val qmtp = Port(209)
    val `z39.50` = Port(210)
    val anet = Port(212)
    val ipx = Port(213)
    val imap3 = Port(220)
    val link = Port(245)
    val pawserv = Port(345)
    val zserv = Port(346)
    val fatserv = Port(347)
    val scoi2odialog = Port(360)
    val semantix = Port(361)
    val srssend = Port(362)
    val rsvp_tunnel = Port(363)
    val `aurora-cmgr` = Port(364)
    val dtk = Port(365)
    val odmr = Port(366)
    val rpc2portmap = Port(369)
    val codaauth2 = Port(370)
    val clearcase = Port(371)
    val ulistproc = Port(372)
    val ldap = Port(389)
    val imsp = Port(406)
    val svrloc = Port(427)
    val `mobileip-agent` = Port(434)
    val `mobilip-mn` = Port(435)
    val https = Port(443)
    val snpp = Port(444)
    val `microsoft-ds` = Port(445)
    val kpasswd = Port(464)
    val urd = Port(465)
    val photuris = Port(468)
    val rcp = Port(469)
    val saft = Port(487)
    val `gss-http` = Port(488)
    val `pim-rp-disc` = Port(496)
    val isakmp = Port(500)
    val exec = Port(512)
    val login = Port(513)
    val shell = Port(514)
    val printer = Port(515)
    val videotex = Port(516)
    val talk = Port(517)
    val ntalk = Port(518)
    val utime = Port(519)
    val efs = Port(520)
    val ripng = Port(521)
    val ulp = Port(522)
    val `ibm-db2` = Port(523)
    val ncp = Port(524)
    val timed = Port(525)
    val tempo = Port(526)
    val courier = Port(530)
    val conference = Port(531)
    val netnews = Port(532)
    val netwall = Port(533)
    val `mm-admin` = Port(534)
    val iiop = Port(535)
    val `opalis-rdv` = Port(536)
    val nmsp = Port(537)
    val gdomap = Port(538)
    val uucp = Port(540)
    val klogin = Port(543)
    val kshell = Port(544)
    val appleqtcsrvr = Port(545)
    val `dhcpv6-client` = Port(546)
    val `dhcpv6-server` = Port(547)
    val afpovertcp = Port(548)
    val rtsp = Port(554)
    val dsf = Port(555)
    val remotefs = Port(556)
    val nntps = Port(563)
    val `9pfs` = Port(564)
    val whoami = Port(565)
    val submission = Port(587)
    val `http-alt` = Port(591)
    val nqs = Port(607)
    val `npmp-local` = Port(610)
    val `npmp-gui` = Port(611)
    val `hmmp-ind` = Port(612)
    val cryptoadmin = Port(624)
    val dec_dlm = Port(625)
    val asia = Port(626)
    val `passgo-tivoli` = Port(627)
    val qmqp = Port(628)
    val `3com-amp3` = Port(629)
    val rda = Port(630)
    val ipp = Port(631)
    val ldaps = Port(636)
    val tinc = Port(655)
    val acap = Port(674)
    val asipregistry = Port(687)
    val `realm-rusd` = Port(688)
    val nmap = Port(689)
    val `ha-cluster` = Port(694)
    val epp = Port(700)
    val `iris-beep` = Port(702)
    val silc = Port(706)
    val `kerberos-adm` = Port(749)
    val `kerberos-iv` = Port(750)
    val pump = Port(751)
    val qrh = Port(752)
    val rrh = Port(753)
    val tell = Port(754)
    val nlogin = Port(758)
    val con = Port(759)
    val ns = Port(760)
    val webster = Port(765)
    val phonebook = Port(767)
    val rsync = Port(873)
    val `ftps-data` = Port(989)
    val ftps = Port(990)
    val nas = Port(991)
    val telnets = Port(992)
    val imaps = Port(993)
    val ircs = Port(994)
    val pop3s = Port(995)
    val imgames = Port(1077)
    val socks = Port(1080)
    val rmiregistry = Port(1099)
    val bnetgame = Port(1119)
    val bnetfile = Port(1120)
    val hpvmmcontrol = Port(1124)
    val hpvmmagent = Port(1125)
    val hpvmmdata = Port(1126)
    val resacommunity = Port(1154)
    val `3comnetman` = Port(1181)
    val `mysql-cluster` = Port(1186)
    val alias = Port(1187)
    val openvpn = Port(1194)
    val kazaa = Port(1214)
    val bvcontrol = Port(1236)
    val nessus = Port(1241)
    val h323hostcallsc = Port(1300)
    val lotusnote = Port(1352)
    val `ms-sql-s` = Port(1433)
    val `ms-sql-m` = Port(1434)
    val ica = Port(1494)
    val wins = Port(1512)
    val ingreslock = Port(1524)
    val `prospero-np` = Port(1525)
    val datametrics = Port(1645)
    val `sa-msg-port` = Port(1646)
    val rsap = Port(1647)
    val `concurrent-lm` = Port(1648)
    val kermit = Port(1649)
    val l2tp = Port(1701)
    val h323gatedisc = Port(1718)
    val h323gatestat = Port(1719)
    val h323hostcall = Port(1720)
    val iberiagames = Port(1726)
    val gamegen1 = Port(1738)
    val `tftp-mcast` = Port(1758)
    val hello = Port(1789)
    val radius = Port(1812)
    val `radius-acct` = Port(1813)
    val mtp = Port(1911)
    val egs = Port(1926)
    val `unix-status` = Port(1957)
    val hsrp = Port(1985)
    val licensedaemon = Port(1986)
    val `tr-rsrb-p1` = Port(1987)
    val `tr-rsrb-p2` = Port(1988)
    val `tr-rsrb-p3` = Port(1989)
    val `stun-p1` = Port(1990)
    val `stun-p2` = Port(1991)
    val `stun-p3` = Port(1992)
    val `snmp-tcp-port` = Port(1994)
    val `stun-port` = Port(1995)
    val `perf-port` = Port(1996)
    val `gdp-port` = Port(1997)
    val `x25-svc-port` = Port(1998)
    val `tcp-id-port` = Port(1999)
    val `cisco-sccp` = Port(2000)
    val nfs = Port(2049)
    val radsec = Port(2083)
    val gnunet = Port(2086)
    val `rtcm-sc104` = Port(2101)
    val `zephyr-srv` = Port(2102)
    val `zephyr-clt` = Port(2103)
    val `zephyr-hm` = Port(2104)
    val eyetv = Port(2170)
    val `msfw-storage` = Port(2171)
    val `msfw-s-storage` = Port(2172)
    val `msfw-replica` = Port(2173)
    val `msfw-array` = Port(2174)
    val airsync = Port(2175)
    val rapi = Port(2176)
    val qwave = Port(2177)
    val tivoconnect = Port(2190)
    val tvbus = Port(2191)
    val `mysql-im` = Port(2273)
    val `dict-lookup` = Port(2289)
    val redstorm_join = Port(2346)
    val redstorm_find = Port(2347)
    val redstorm_info = Port(2348)
    val cvspserver = Port(2401)
    val venus = Port(2430)
    val `venus-se` = Port(2431)
    val codasrv = Port(2432)
    val `codasrv-se` = Port(2433)
    val netadmin = Port(2450)
    val netchat = Port(2451)
    val snifferclient = Port(2452)
    val ppcontrol = Port(2505)
    val lstp = Port(2559)
    val mon = Port(2583)
    val hpstgmgr = Port(2600)
    val `discp-client` = Port(2601)
    val `discp-server` = Port(2602)
    val servicemeter = Port(2603)
    val `nsc-ccs` = Port(2604)
    val `nsc-posa` = Port(2605)
    val netmon = Port(2606)
    val connection = Port(2607)
    val `wag-service` = Port(2608)
    val dict = Port(2628)
    val exce = Port(2769)
    val `dvr-esm` = Port(2804)
    val corbaloc = Port(2809)
    val ndtp = Port(2882)
    val gamelobby = Port(2914)
    val gds_db = Port(3050)
    val xbox = Port(3074)
    val icpv2 = Port(3130)
    val `nm-game-admin` = Port(3148)
    val `nm-game-server` = Port(3149)
    val mysql = Port(3306)
    val sftu = Port(3326)
    val trnsprntproxy = Port(3346)
    val `ms-wbt-server` = Port(3389)
    val prsvp = Port(3455)
    val nut = Port(3493)
    val ironstorm = Port(3504)
    val `cctv-port` = Port(3559)
    val `iw-mmogame` = Port(3596)
    val distcc = Port(3632)
    val daap = Port(3689)
    val svn = Port(3690)
    val blizwow = Port(3724)
    val `netboot-pxe` = Port(3928)
    val `smauth-port` = Port(3929)
    val treehopper = Port(3959)
    val cobraclient = Port(3970)
    val cobraserver = Port(3971)
    val `pxc-spvr-ft` = Port(4002)
    val `pxc-splr-ft` = Port(4003)
    val `pxc-roid` = Port(4004)
    val `pxc-pin` = Port(4005)
    val `pxc-spvr` = Port(4006)
    val `pxc-splr` = Port(4007)
    val xgrid = Port(4111)
    val bzr = Port(4155)
    val rwhois = Port(4321)
    val epmd = Port(4369)
    val krb524 = Port(4444)
    val `ipsec-nat-t` = Port(4500)
    val hylafax = Port(4559)
    val piranha1 = Port(4600)
    val `playsta2-app` = Port(4658)
    val `playsta2-lob` = Port(4659)
    val snap = Port(4752)
    val `radmin-port` = Port(4899)
    val rfe = Port(5002)
    val `ita-agent` = Port(5051)
    val `sdl-ets` = Port(5081)
    val bzflag = Port(5154)
    val aol = Port(5190)
    val `xmpp-client` = Port(5222)
    val caevms = Port(5251)
    val `xmpp-server` = Port(5269)
    val cfengine = Port(5308)
    val `nat-pmp` = Port(5351)
    val `dns-llq` = Port(5352)
    val mdns = Port(5353)
    val mdnsresponder = Port(5354)
    val llmnr = Port(5355)
    val `dj-ice` = Port(5419)
    val `beyond-remote` = Port(5424)
    val `br-channel` = Port(5425)
    val postgresql = Port(5432)
    val `sgi-eventmond` = Port(5553)
    val `sgi-esphttp` = Port(5554)
    val cvsup = Port(5999)
    val x11 = Port(6000)
    val `kftp-data` = Port(6620)
    val kftp = Port(6621)
    val ktelnet = Port(6623)
    val `gnutella-svc` = Port(6346)
    val `gnutella-rtr` = Port(6347)
    val `sane-port` = Port(6566)
    val `parsec-game` = Port(6582)
    val `afs3-fileserver` = Port(7000)
    val `afs3-callback` = Port(7001)
    val `afs3-prserver` = Port(7002)
    val `afs3-vlserver` = Port(7003)
    val `afs3-kaserver` = Port(7004)
    val `afs3-volser` = Port(7005)
    val `afs3-errors` = Port(7006)
    val `afs3-bos` = Port(7007)
    val `afs3-update` = Port(7008)
    val `afs3-rmtsys` = Port(7009)
    val `font-service` = Port(7100)
    val sncp = Port(7560)
    val `soap-http` = Port(7627)
    val `http-alt2` = Port(8008)
    val `http-alt3` = Port(8080)
    val sunproxyadmin = Port(8081)
    val pichat = Port(9009)
    val `bacula-dir` = Port(9101)
    val `bacula-fd` = Port(9102)
    val `bacula-sd` = Port(9103)
    val dddp = Port(9131)
    val `wap-wsp` = Port(9200)
    val `wap-wsp-wtp` = Port(9201)
    val `wap-wsp-s` = Port(9202)
    val `wap-wsp-wtp-s` = Port(9203)
    val `wap-vcard` = Port(9204)
    val `wap-vcal` = Port(9205)
    val `wap-vcard-s` = Port(9206)
    val `wap-vcal-s` = Port(9207)
    val git = Port(9418)
    val cba8 = Port(9593)
    val davsrc = Port(9800)
    val sqlexec = Port(9088)
    val `sqlexec-ssl` = Port(9089)
    val sd = Port(9876)
    val `cyborg-systems` = Port(9888)
    val monkeycom = Port(9898)
    val `sctp-tunneling` = Port(9899)
    val domaintime = Port(9909)
    val amanda = Port(10080)
    val vce = Port(11111)
    val smsqp = Port(11201)
    val hkp = Port(11371)
    val h323callsigalt = Port(11720)
    val `rets-ssl` = Port(12109)
    val cawas = Port(12168)
    val bprd = Port(13720)
    val bpdbm = Port(13721)
    val `bpjava-msvc` = Port(13722)
    val vnetd = Port(13724)
    val bpcd = Port(13782)
    val vopied = Port(13783)
    val xpilot = Port(15345)
    val wnn6 = Port(22273)
    val binkp = Port(24554)
    val quake = Port(26000)
    val `wnn6-ds` = Port(26208)
    val tetrinet = Port(31457)
    val `gamesmith-port` = Port(31765)
    val traceroute = Port(33434)
    val candp = Port(42508)
    val candrp = Port(42509)
    val caerpc = Port(42510)
    val kpop = Port(1109)
    val knetd = Port(2053)
    val eklogin = Port(2105)
    val supfilesrv = Port(871)
    val supfiledbg = Port(1127)
    val swat = Port(901)
    val rndc = Port(953)
    val skkserv = Port(1178)
    val xtel = Port(1313)
    val support = Port(1529)
    val cfinger = Port(2003)
    val ninstall = Port(2150)
    val afbackup = Port(2988)
    val fax = Port(4557)
    val rplay = Port(5555)
    val canna = Port(5680)
    val `x11-ssh` = Port(6010)
    val ircd = Port(6667)
    val jetdirect = Port(9100)
    val kamanda = Port(10081)
    val amandaidx = Port(10082)
    val amidxtape = Port(10083)
    val isdnlog = Port(20011)
    val vboxd = Port(20012)
    val wnn4_Cn = Port(22289)
    val wnn4_Kr = Port(22305)
    val wnn4_Tw = Port(22321)
    val asp = Port(27374)
    val tfido = Port(60177)
    val fido = Port(60179)
  }
}