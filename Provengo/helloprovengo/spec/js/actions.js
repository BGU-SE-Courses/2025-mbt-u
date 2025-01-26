//@provengo summon ctrl

function customerLogIn(session) {
  sync({request: Event('Start(customerLogIn)')});
  with (session) {
    click(xpaths_Customer.HomePage.myAccountButton);
    click(xpaths_Customer.HomePage.loginButton);
    writeText(xpaths_Customer.loginWindow.email, data.email);
    writeText(xpaths_Customer.loginWindow.password, data.password);
    // runCode(scrolling.down);
    click(xpaths_Customer.loginWindow.loginButton);
  }
  sync({
    request: Event('End(customerLogIn)'),
    request: Ctrl.markEvent('End(customerLogIn)')
  });
}

function customerSearchProduct(session) {
  sync({request: Event('Start(customerSearchProduct)'),
        waitFor: Event('End(customerLogIn)')})

  with(session) {
    // Search for a product
    writeText(xpaths_Customer.ProductPage.searchInput, product)
    click(xpaths_Customer.ProductPage.searchButton)
  }
  sync({
    request: Event('End(customerSearchProduct)'),
    request: Ctrl.markEvent('End(customerSearchProduct)')})
}

function customerAddToCart(session) {
  sync({request:  Event('Start(customerAddToCart)'),
        block:    Event('Start(AdminEditsProductQuantity)'),
        waitFor:  Event('End(customerSearchProduct)')})
  with(session) {
    // Scroll to the bottom of the page
    // runCode(scrolling.down)
    // Wait for clickable to appear
    waitForClickability(xpaths_Customer.ProductPage.addToCartButton)
    // Add product to cart
    click(xpaths_Customer.ProductPage.addToCartButton)
    click(xpaths_Customer.ProductPage.addToCartButton)

    // Get success message
    waitForVisibility(xpaths_Customer.ProductPage.addedToCartMessage)
  }
  sync({
    request: Event('End(customerAddToCart)'),
    request: Ctrl.markEvent('End(customerAddToCart)')})
}

function customerNavigateToCheckout(session) {
  sync({request: Event('Start(customerNavigateToCheckout)'),
        block:   Event('Start(AdminUpdatedQuantityBeforeCustomer)'),
        waitFor: Event('End(customerAddToCart)')})
  with(session) {
    // Scroll up
    // runCode(scrolling.up)
    // wait for items in cart to appear
    waitForVisibility(xpaths_Customer.clearShoppingCart.cartButton)
    // Navigate to the checkout page
    click(xpaths_Customer.clearShoppingCart.cartButton)
    click(xpaths_Customer.clearShoppingCart.checkoutButton)
  }
  sync({
    request:  Event('End(customerNavigateToCheckout)'),
    allow:    Event('End(AdminEditsProductQuantity)'),
    request:  Ctrl.markEvent('End(customerNavigateToCheckout)')})
}

function AdminLogin(session) {
  sync({request: Event('Start(AdminLogin)')})
  with(session) {
    // Login
    writeText(xpath_Admin.loginWindow.username, data.username)
    writeText(xpath_Admin.loginWindow.password, data.adminPassword)
    click(xpath_Admin.loginWindow.loginButton)
  }
  sync({
    request: Event('End(AdminLogin)'),
    request: Ctrl.markEvent('End(AdminLogin)')})
}

function AdminChooseCatalog(session) {
  sync({request: Event('Start(AdminChooseCatalog)'),
        waitFor: Event('End(AdminLogin)')})
  with(session) {
    // Choose Catalog
    click(xpath_Admin.AdminCatalog.navigateButtons)
    click(xpath_Admin.AdminCatalog.catalogButton)
  }
  sync({
    request: Event('End(AdminChooseCatalog)'),
    request: Ctrl.markEvent('End(AdminChooseCatalog)')})
}

function AdminChooseProducts(session) {
  sync({request: Event('Start(AdminChooseProducts)'),
        waitFor: Event('End(AdminChooseCatalog)')})
  with(session) {
    // Choose Products
    click(xpath_Admin.AdminProducts.productsButton)
  }
  sync({
    request: Event('End(AdminChooseProducts)'),
    request: Ctrl.markEvent('End(AdminChooseProducts)')})
}

function AdminFilterProducts(session) {
  sync({request: Event('Start(AdminFilterProducts)'),
        waitFor: Event('End(AdminChooseProducts)')})
  with(session) {
    // Filter Products
    // click(xpath_Admin.AdminEditProduct.filterButton)
    // Search for a product
    writeText(xpath_Admin.AdminEditProduct.AdminChooseSearchButton, product)
    click(xpath_Admin.AdminEditProduct.confirmEditButton)
    click(xpath_Admin.AdminEditProduct.savingButton)

  }
  sync({
    request: Event('End(AdminFilterProducts)'),
    request: Ctrl.markEvent('End(AdminFilterProducts)')})
}

function AdminEditsProductQuantity(session) {
  sync({request: Event('Start(AdminEditsProductQuantity)'),
        waitFor: Event('End(AdminFilterProducts)')})
  with(session) {
    // Edit Product
    click(xpath_Admin.AdminDataTab.dataTab)
    // runCode(scrolling.down)
    writeText(xpath_Admin.AdminQuantity.quantityInput, quantity, clearBeforeWrite=true)
    // runCode(scrolling.up)
    click(xpath_Admin.AdminSaving.saveButton)
  }
  sync({
    request: Event('End(AdminEditsProductQuantity)'),
    request: Ctrl.markEvent('End(AdminEditsProductQuantity)')})
}

function AdminUpdatedQuantityBeforeCustomer(session) {
  sync({request: Event('Start(AdminUpdatedQuantityBeforeCustomer)'),
        block:   Event('Start(customerNavigateToCheckout)'),
        waitFor: Event('End(AdminEditsProductQuantity)')})
  with(session) {
    // wait for items in cart to appear
    waitForVisibility(xpaths_Customer.clearShoppingCart.cartButton)
    // Navigate to the checkout page
    click(xpaths_Customer.clearShoppingCart.cartButton)
    waitForVisibility(xpaths_Customer.clearShoppingCart.errorMsg)
  }
    sync({
        request: Event('End(AdminUpdatedQuantityBeforeCustomer)'),
        //allow:   Event('End(customerNavigateToCheckout)'),
        request: Ctrl.markEvent('End(AdminUpdatedQuantityBeforeCustomer)')})
}


