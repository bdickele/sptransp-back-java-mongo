var conn = new Mongo();
var db = conn.getDB("sptransp_test");

db.users.drop();
db.createCollection("users");

// ==== Employees ====

db.users.insert({id: 1, version: 1, userType: "E", uid: "kvcquz31", password: "changeme", fullName: "Kathleen Carpenter",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "LAW_COMPLIANCE", departmentLabel: "Law compliance", seniority: 20, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", full_name: "Kathleen Carpenter", profileCode: "AGR_VISA_APPLIER", departmentCode: "LAW_COMPLIANCE", seniority: 20}
    ]});

db.users.insert({id: 2, version: 1, userType: "E", uid: "whlofu42", password: "changeme", fullName: "Helen Cox",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "SHUTTLE_COMPLIANCE", departmentLabel: "Shuttle compliance", seniority: 20, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", full_name: "Helen Cox", profileCode: "AGR_VISA_APPLIER", departmentCode: "SHUTTLE_COMPLIANCE", seniority: 20}
    ]});

db.users.insert({id: 3, version: 1, userType: "E", uid: "xhtqyi65", password: "changeme", fullName: "Paula Spencer",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "GOODS_INSPECTION", departmentLabel: "Goods inspection", seniority: 20, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Paula Spencer", profileCode: "AGR_VISA_APPLIER", departmentCode: "GOODS_INSPECTION", seniority: 20}
    ]});

db.users.insert({id: 4, version: 1, userType: "E", uid: "xzjwsm38", password: "changeme", fullName: "Juan Hughes",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "JOURNEY_SUPERVISION", departmentLabel: "Journey supervision", seniority: 20, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Juan Hughes", profileCode: "AGR_VISA_APPLIER", departmentCode: "JOURNEY_SUPERVISION", seniority: 20}
    ]});

db.users.insert({id: 5, version: 1, userType: "E", uid: "loncvj78", password: "changeme", fullName: "Ashley Wheeler",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "HR", departmentLabel: "Human resources", seniority: 20, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Ashley Wheeler", profileCode: "AGR_VISA_APPLIER", departmentCode: "HR", seniority: 20}
    ]});

db.users.insert({id: 6, version: 1, userType: "E", uid: "tbikem91", password: "changeme", fullName: "Ruby Rogers",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "LAW_COMPLIANCE", departmentLabel: "Law compliance", seniority: 60, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Ruby Rogers", profileCode: "AGR_VISA_APPLIER", departmentCode: "LAW_COMPLIANCE", seniority: 60}
    ]});

db.users.insert({id: 7, version: 1, userType: "E", uid: "dryiwn36", password: "changeme", fullName: "Joyce Cruz",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "SHUTTLE_COMPLIANCE", departmentLabel: "Shuttle compliance", seniority: 60, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Joyce Cruz", profileCode: "AGR_VISA_APPLIER", departmentCode: "SHUTTLE_COMPLIANCE", seniority: 60}
    ]});

db.users.insert({id: 8, version: 1, userType: "E", uid: "rajoqm34", password: "changeme", fullName: "Jack Henry",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "GOODS_INSPECTION", departmentLabel: "Goods inspection", seniority: 60, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Jack Henry", profileCode: "AGR_VISA_APPLIER", departmentCode: "GOODS_INSPECTION", seniority: 60}
    ]});

db.users.insert({id: 9, version: 1, userType: "E", uid: "gjixqn84", password: "changeme", fullName: "Denise Rodriguez",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "JOURNEY_SUPERVISION", departmentLabel: "Journey supervision", seniority: 60, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Denise Rodriguez", profileCode: "AGR_VISA_APPLIER", departmentCode: "JOURNEY_SUPERVISION", seniority: 60}
    ]});

db.users.insert({id: 10, version: 1, userType: "E", uid: "pytlvi73", password: "changeme", fullName: "Justin Williamson",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "HR", departmentLabel: "Human resources", seniority: 60, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Justin Williamson", profileCode: "AGR_VISA_APPLIER", departmentCode: "HR", seniority: 60}
    ]});

db.users.insert({id: 11, version: 1, userType: "E", uid: "qlomny06", password: "changeme", fullName: "Gregory Bradley",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "LAW_COMPLIANCE", departmentLabel: "Law compliance", seniority: 90, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Gregory Bradley", profileCode: "AGR_VISA_APPLIER", departmentCode: "LAW_COMPLIANCE", seniority: 90}
    ]});

db.users.insert({id: 12, version: 1, userType: "E", uid: "xkmvis52", password: "changeme", fullName: "Julie Lopez",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "SHUTTLE_COMPLIANCE", departmentLabel: "Shuttle compliance", seniority: 90, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Julie Lopez", profileCode: "AGR_VISA_APPLIER", departmentCode: "SHUTTLE_COMPLIANCE", seniority: 90}
    ]});

db.users.insert({id: 13, version: 1, userType: "E", uid: "kvieon14", password: "changeme", fullName: "Maria Dunn",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "GOODS_INSPECTION", departmentLabel: "Goods inspection", seniority: 90, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Maria Dunn", profileCode: "AGR_VISA_APPLIER", departmentCode: "GOODS_INSPECTION", seniority: 90}
    ]});

db.users.insert({id: 14, version: 1, userType: "E", uid: "figlva46", password: "changeme", fullName: "Randy Richards",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "JOURNEY_SUPERVISION", departmentLabel: "Journey supervision", seniority: 90, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Randy Richards", profileCode: "AGR_VISA_APPLIER", departmentCode: "JOURNEY_SUPERVISION", seniority: 90}
    ]});

db.users.insert({id: 15, version: 1, userType: "E", uid: "ponley99", password: "changeme", fullName: "Russell Burke",
    profileCode: "AGR_VISA_APPLIER", creationDate: "20/12/2015 17:54:05", creationUser: "script", updateDate: "20/12/2015 17:54:05",
    updateUser: "script", departmentCode: "HR", departmentLabel: "Human resources", seniority: 90, history: [
        {version: 1, versionDate: "20/12/2015 17:54:05", versionUser: "script", fullName: "Russell Burke", profileCode: "AGR_VISA_APPLIER", departmentCode: "HR", seniority: 90}
    ]});

// ==== Customers ====

db.users.insert({id: 31, version: 1, userType: "C", uid: "timulf70", password: "changeme", fullName: "Jabberstorm",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Jabberstorm", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 32, version: 1, userType: "C", uid: "bxcegf67", password: "changeme", fullName: "Quamba",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Quamba", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 33 , version: 1, userType: "C", uid: "pvdauc04", password: "changeme", fullName: "Viva",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Viva", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 34, version: 1, userType: "C", uid: "qirtjp96", password: "changeme", fullName: "Topicstorm",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Topicstorm", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 35, version: 1, userType: "C", uid: "spzgde71", password: "changeme", fullName: "Babbleset",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Babbleset", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 36, version: 1, userType: "C", uid: "mleots02", password: "changeme", fullName: "Skinix",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Skinix", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 37, version: 1, userType: "C", uid: "rxokeh92", password: "changeme", fullName: "Feedmix",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Feedmix", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 38, version: 1, userType: "C", uid: "hadkrx11", password: "changeme", fullName: "Zoombeat",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Zoombeat", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 39, version: 1, userType: "C", uid: "hybmgk57", password: "changeme", fullName: "Fanoodle",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Fanoodle", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 40, version: 1, userType: "C", uid: "pfdxtv63", password: "changeme", fullName: "Bubbletube",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Bubbletube", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 41, version: 1, userType: "C", uid: "ckgqhi62", password: "changeme", fullName: "Izio",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Izio", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 42, version: 1, userType: "C", uid: "rkpvxy15", password: "changeme", fullName: "Jaxnation",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Jaxnation", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 43, version: 1, userType: "C", uid: "raqlew87", password: "changeme", fullName: "Wikizz",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Wikizz", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 44, version: 1, userType: "C", uid: "bauhqr22", password: "changeme", fullName: "Jabberstorm2",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Jabberstorm2", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 45, version: 1, userType: "C", uid: "jgzlrm63", password: "changeme", fullName: "Skidoo",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Skidoo", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 46, version: 1, userType: "C", uid: "laehrn93", password: "changeme", fullName: "Kare",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Kare", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 47, version: 1, userType: "C", uid: "lkpmeh63", password: "changeme", fullName: "Zoonoodle",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Zoonoodle", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 48, version: 1, userType: "C", uid: "ejasof61", password: "changeme", fullName: "Jamia",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Jamia", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 49, version: 1, userType: "C", uid: "uqhjdk29", password: "changeme", fullName: "Skiptube",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Skiptube", profileCode: "CUSTOMER"}
    ]});

db.users.insert({id: 50, version: 1, userType: "C", uid: "xtbhuf68", password: "changeme", fullName: "Plajo",
    profileCode: "CUSTOMER", creationDate: "29/09/2015 14:44:46", creationUser: "script", updateDate: "29/09/2015 14:44:46", updateUser: "script", history: [
        {version: 1, versionDate: "29/09/2015 14:44:46", versionUser: "script", fullName: "Plajo", profileCode: "CUSTOMER"}
    ]});
