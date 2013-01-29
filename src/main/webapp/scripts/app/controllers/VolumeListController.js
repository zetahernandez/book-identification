define([ "require", "ember"], function(r,Ember) {
    var VolumeListController = Ember.ArrayController.extend({
        page:1,
        category: null,
        init: function (){
          this.showAll();
          Ember.run.later(this, "addInfiniteScroll",2000);
        },
        addInfiniteScroll: function (){
            var instance = this;
            $("#infiniteScroll").endlessScroll({
              loader: '<div class="loading"><div>',
              ceaseFireOnEmpty: false,
              
              content: function (fireSequence,pageSequence,scrollDirection){
                    return " "; 
              },
              callback: function(fireSequence,pageSequence,scrollDirection){
                  if ( scrollDirection == "next"){
                    instance.addMoreVolumes( instance.get("page") + 1 );
                  }
              }
          });
        },
        filterByCategory : function(category) {
            this.category = category;
            var content = BooksApp.Volume.find({
                "categoryId": category.get('id'),"page":1
                });
                this.set('content',content);
        },
        showAll : function() {
            this.set("page",1);
            this.set('content',	BooksApp.Volume.find({
                "page":1
            }));
        },
        
        contentChanged: function() {
            var mutableVolumes = [];
            this.get('content').forEach(function(vol) {
                mutableVolumes.pushObject(vol);
            });

            this.set('currentVolumes', mutableVolumes);
        }.observes('content', 'content.isLoaded'),

        addMoreVolumes : function ( page ){
            
           var mutableVolumes = [],  data = {};

            this.page = page;
            
            if ( this.category != null ){
               data.categoryId = this.category.get("id");
               data.page = page;
            }else{
               data.page = page;
            }

            var books = BooksApp.Volume.find( data );
  
//            this.get('content').forEach(function(vol) {
//                mutableVolumes.pushObject(vol);
//            });
            
            books.forEach(function(vol) {
                mutableVolumes.pushObject(vol);
            });
            this.get('currentVolumes').pushObjects( mutableVolumes );
        }
    });
    return VolumeListController;
});