#!/usr/bin/perl
#!perl.exe

use Tk;


my $mw = MainWindow->new;

$mw->geometry("600x300+50+50");
$mw->title("Checkout files find...");

$mw->Button(-text => "Done", -command => sub { exit })->pack;



MainLoop;