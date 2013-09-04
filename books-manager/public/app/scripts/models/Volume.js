BooksManager.Volume = DS.Model.extend({
  bookId: DS.attr({ type: 'string' }),
  kind: DS.attr({ type: 'string' }),
  path: DS.attr({ type: 'string' }),
  volumeInfo: DS.belongsTo('volume-info')
});