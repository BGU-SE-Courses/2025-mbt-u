//@provengo summon selenium

bthread('CustomerScenario', function () {
  let s1 = new SeleniumSession(CUSTOMER_SESSION);
  s1.start(CUSTOMER_URL);
  customerLogIn(s1);
  customerSearchProduct(s1);
  customerAddToCart(s1);
  customerNavigateToCheckout(s1);
  AdminUpdatedQuantityBeforeCustomer(s1);
})

bthread('AdminScenario', function () {
  let s2 = new SeleniumSession(ADMIN_SESSION);
  s2.start(ADMIN_URL);
  AdminLogin(s2);
  AdminChooseCatalog(s2);
  AdminChooseProducts(s2);
  AdminFilterProducts(s2);
  AdminEditsProductQuantity(s2);
})

