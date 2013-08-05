BooksManager.Volumeinfo = DS.Model.extend({
  authors: DS.attr('string'),
  description: DS.attr('string'),
  imageLinks: DS.belongsTo('BooksManager.ImageLink'),
  industryIdentifiers: DS.hasMany('BooksManager.IndustryIdentifier'),
  title: DS.attr('string'),
  subtitle: DS.attr('string'),
  publisher: DS.attr('string'),
  pages: DS.attr('number'),
  publishedDate: DS.attr('date'),
  categories: DS.hasMany('BooksManager.Category'),

  unescapedDescription: function () {
    return this.get('description').htmlSafe();
  }.property('description'),

  formattedPublishedDate: function () {
    if (this.get('publishedDate')) {
      return this.get('publishedDate').getUTCDay() + "/" + (this.get('publishedDate').getUTCMonth() + 1) + "/" + this.get('publishedDate').getUTCFullYear();
    }

    return '';
  }.property('publishedDate').cacheable()

});