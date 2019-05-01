<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="ui.bootstrap.demo">
  <head>
  	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular-resource.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular-animate.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular-sanitize.js"></script>
    <script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
    angular.module('ui.bootstrap.demo', ['ngAnimate', 'ngSanitize', 'ui.bootstrap','ngResource']);
    angular.module('ui.bootstrap.demo').controller('ModalDemoCtrl', function ($uibModal, $log, $document) {
      var $ctrl = this;
      $ctrl.items = ['item1', 'item2', 'item3'];

      $ctrl.animationsEnabled = true;

      $ctrl.open = function (size, parentSelector) {
        var parentElem = parentSelector ? 
          angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
        var modalInstance = $uibModal.open({
          animation: $ctrl.animationsEnabled,
          ariaLabelledBy: 'modal-title',
          ariaDescribedBy: 'modal-body',
          templateUrl: 'myModalContent.html',
          controller: 'ModalInstanceCtrl',
          controllerAs: '$ctrl',
          size: size,
          appendTo: parentElem,
          resolve: {
            items: function () {
              return $ctrl.items;
            }
          }
        });

        modalInstance.result.then(function (selectedItem) {
          $ctrl.selected = selectedItem;
        }, function () {
          $log.info('Modal dismissed at: ' + new Date());
        });
      };

      $ctrl.openComponentModal = function () {
        var modalInstance = $uibModal.open({
          animation: $ctrl.animationsEnabled,
          component: 'modalComponent',
          resolve: {
            items: function () {
              return $ctrl.items;
            }
          }
        });

        modalInstance.result.then(function (selectedItem) {
          $ctrl.selected = selectedItem;
        }, function () {
          $log.info('modal-component dismissed at: ' + new Date());
        });
      };

      $ctrl.openMultipleModals = function () {
        $uibModal.open({
          animation: $ctrl.animationsEnabled,
          ariaLabelledBy: 'modal-title-bottom',
          ariaDescribedBy: 'modal-body-bottom',
          templateUrl: 'stackedModal.html',
          size: 'sm',
          controller: function($scope) {
            $scope.name = 'bottom';  
          }
        });

        $uibModal.open({
          animation: $ctrl.animationsEnabled,
          ariaLabelledBy: 'modal-title-top',
          ariaDescribedBy: 'modal-body-top',
          templateUrl: 'stackedModal.html',
          size: 'sm',
          controller: function($scope) {
            $scope.name = 'top';  
          }
        });
      };

      $ctrl.toggleAnimation = function () {
        $ctrl.animationsEnabled = !$ctrl.animationsEnabled;
      };
    });

    // Please note that $uibModalInstance represents a modal window (instance) dependency.
    // It is not the same as the $uibModal service used above.

    angular.module('ui.bootstrap.demo').controller('ModalInstanceCtrl', function ($uibModalInstance, items) {
      var $ctrl = this;
      $ctrl.items = items;
      $ctrl.selected = {
        item: $ctrl.items[0]
      };

      $ctrl.ok = function () {
        $uibModalInstance.close($ctrl.selected.item);
      };

      $ctrl.cancel = function () {
        $uibModalInstance.dismiss('cancel');
      };
    });

    // Please note that the close and dismiss bindings are from $uibModalInstance.

    angular.module('ui.bootstrap.demo').component('modalComponent', {
      templateUrl: 'myModalContent.html',
      bindings: {
        resolve: '<',
        close: '&',
        dismiss: '&'
      },
      controller: function () {
        var $ctrl = this;

        $ctrl.$onInit = function () {
          $ctrl.items = $ctrl.resolve.items;
          $ctrl.selected = {
            item: $ctrl.items[0]
          };
        };

        $ctrl.ok = function () {
          $ctrl.close({$value: $ctrl.selected.item});
        };

        $ctrl.cancel = function () {
          $ctrl.dismiss({$value: 'cancel'});
        };
      }
    });
    </script>
  </head>
  <body>

<div ng-controller="ModalDemoCtrl as $ctrl" class="modal-demo">
    <script type="text/ng-template" id="myModalContent.html">
        <div class="modal-header">
            <h3 class="modal-title" id="modal-title">I'm a modal!</h3>
        </div>
        <div class="modal-body" id="modal-body">
            <ul>
                <li ng-repeat="item in $ctrl.items">
                    <a href="#" ng-click="$event.preventDefault(); $ctrl.selected.item = item">{{ item }}</a>
                </li>
            </ul>
            Selected: <b>{{ $ctrl.selected.item }}</b>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="$ctrl.ok()">OK</button>
            <button class="btn btn-warning" type="button" ng-click="$ctrl.cancel()">Cancel</button>
        </div>
    </script>
    <script type="text/ng-template" id="stackedModal.html">
        <div class="modal-header">
            <h3 class="modal-title" id="modal-title-{{name}}">The {{name}} modal!</h3>
        </div>
        <div class="modal-body" id="modal-body-{{name}}">
            Having multiple modals open at once is probably bad UX but it's technically possible.
        </div>
    </script>

    <button type="button" class="btn btn-default" ng-click="$ctrl.open()">Open me!</button>
    <button type="button" class="btn btn-default" ng-click="$ctrl.open('lg')">Large modal</button>
    <button type="button" class="btn btn-default" ng-click="$ctrl.open('sm')">Small modal</button>
    <button type="button" class="btn btn-default" ng-click="$ctrl.open('sm', '.modal-parent')">
            Modal appended to a custom parent
    </button>
    <button type="button" class="btn btn-default" ng-click="$ctrl.toggleAnimation()">Toggle Animation ({{ $ctrl.animationsEnabled }})</button>
    <button type="button" class="btn btn-default" ng-click="$ctrl.openComponentModal()">Open a component modal!</button>
    <button type="button" class="btn btn-default" ng-click="$ctrl.openMultipleModals()">
        Open multiple modals at once 
    </button>
    <div ng-show="$ctrl.selected">Selection from a modal: {{ $ctrl.selected }}</div>
    <div class="modal-parent">
    </div>
</div>
  </body>
</html>