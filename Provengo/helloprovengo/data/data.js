/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const CUSTOMER_SESSION = "CustomerSession"
const CUSTOMER_URL = "http://localhost/opencartsite/"

const ADMIN_SESSION = "AdminSession"
const ADMIN_URL = "http://localhost/opencartsite/admin1/index.php?route=common/login"


const xpaths_Customer = {
  HomePage:{
    myAccountButton: "//*[@id='top']/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/a[1]/i[2]",
    loginButton: "//*[@id='top']/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/ul[1]/li[2]/a[1]"
  },
  loginWindow: {
      email: "//*[@id='input-email']",
      password: "//*[@id='input-password']",
      loginButton: "//*[@id='form-login']/div[3]/button[1]"
  },
  ProductPage: {
    searchInput: "//*[@name=\"search\"]",
    searchButton: "//button[@type=\"submit\"]",
    addToCartButton: "//form[1]/div[1]/button[1]",
    addedToCartMessage: "//*[@id='alert']/div[1]"
  },
  clearShoppingCart: {
    cartButton: "//*[@id='cart']/div[1]/button[1]",
    removeAllProductsButton: "//*[@id='cart']/div/ul/li/table/tbody/tr/td/form/button[1]",
  }
}

const xpath_Admin = {
  loginWindow: {
    username: '//input[@id="input-username"]',
    password: '//input[@id="input-password"]',
    loginButton: '//button[@type="submit"]'
  },
  FindLoginButton: {
    loginButton: "//*[@type=\"submit\"]"
  },
  AdminCatalog: {
    navigateButtons: "/html/body/div[@id='container']/header[@id='header']/div[@class='container-fluid']/button[@id='button-menu']/i[@class='fa-solid fa-bars']",
    catalogButton: "//*[@id='menu-catalog']/a[1]"
  },
  AdminProducts: {
    productsButton: "//*[@id='collapse-1']/li[2]/a[1]"
  },
  AdminEditProduct: {
    filterButton: "/html/body/div[@id='container']/div[@id='content']/div[@class='page-header']/div[@class='container-fluid']/div[@class='float-end']/button[@class='btn btn-light d-lg-none']",
    AdminChooseSearchButton: "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/input",
    confirmEditButton: "//*[@id=\"form-product\"]/div[1]/table/tbody/tr/td[7]/div/a"
  },
  AdminDataTab: {
    dataTab: "//*[@id='form-product']/ul[1]/li[2]/a[1]"
  },
  AdminQuantity: {
    quantityInput: "//*[contains(@name, \"quantity\")]"
  },
  AdminSaving: {
    saveButton: "//*[@id='content']/div/div/div/button[1]"
  },
  AdminRestringQuantity: {
    quantityInput: "//*[contains(@name, \"quantity\")]"
  }

}

const scrolling = {
  down: "window.scrollTo(0, document.body.scrollHeight);",
  up: "window.scrollTo(0, 0);"
}

const customerMail = "hagai@gmail.com"
const customerPassword = "123456"
const adminUsername = "admin"
const adminPassword = "1234"
const product = "iMac"
const quantity = "1"