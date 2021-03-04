import { EcoCommerceFrontPage } from './app.po';

describe('eco-commerce-front App', function() {
  let page: EcoCommerceFrontPage;

  beforeEach(() => {
    page = new EcoCommerceFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
