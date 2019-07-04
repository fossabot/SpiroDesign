import spirogear.MVC.mvc.Model;
import spirogear.MVC.mvc.Controller;
import spirogear.MVC.mvc.View;
import spirogear.Cons.cons.Cons;
import spirogear.Cons.cons.Symbol;
import java.awt.Rectangle;
import java.util.Hashtable;
import java.awt.Point;
import java.awt.geom.Point2D;

public class SpiroGear extends Object {

 private Point2D.Double center;

 private Double radius;

 public SpiroGear() {
  this.center = new Point2D.Double(400.0,300.0);
  this.radius = 100.0;
  //System.out.println("test");
 }

 public SpiroGear(Double x, Double y) {

 }

 public SpiroGear(Double x, Double y, Double r) {

 }

  //public SpiroGear(Double p, Double r) {

  //}

 public SpiroGear(Double r) {

 }

 public Double bottom() {
  return null;
 }

 public Rectangle bottomRectangle() {
  return null;
 }

 public Double center() {
  return null;
 }

 public void center(Double x, Double y) {
  //System.out.println("test");
 }

 public Rectangle centerRectangle() {
  return null;
 }

 public Double circumference() {
  return null;
 }

 // public Hashtable<Symbol,Object> fromList(Cons aList) {
 //  return null;
 // }

 public Double left() {
  return null;
 }

 public Rectangle leftRectangle() {
  return null;
 }

 public Double radius() {
  return null;
 }

 public void radius(Double r) {
  System.out.println("test");
 }

 public Double right() {
  return null;
 }

 public Rectangle rightRectangle() {
  return null;
 }

 public Double rotate(Double point, Double degrees) {
  return null;
 }

 public Double rotate(Double point, Double degrees, Double around) {
  return null;
 }

 public Double top() {
  return null;
 }

 public Rectangle topRectangle() {
  return null;
 }

 public Rectangle toRectangle(Double aPoint, Double expandedAmount) {
  return null;
 }

 // public Cons toList() {
 //  return null;
 // }

 public String toString() {
  return null;
 }

}
