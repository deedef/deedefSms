/**
 * Created by S2D on 5/31/15.
 */

/*
Main Controller:
    It depends on many other controllers.
    These other controllers each have a specific functionality or purpose.
    They are separated for better structure of the overall application logic.
 */
var deedefsmsControllers = angular.module('deedefsmsControllers',[
    'DashboardModule',
    'SendModule',
    'SentModule',
    'ContactsModule',
    'CreditsModule',
    'SettingsModule'
]);