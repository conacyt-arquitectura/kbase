import { BForm } from 'bootstrap-vue';
import { BFormInput } from 'bootstrap-vue';
import { BFormCheckbox } from 'bootstrap-vue';
import { BFormGroup } from 'bootstrap-vue';
import { BProgress } from 'bootstrap-vue';
import { BProgressBar } from 'bootstrap-vue';
import { BPagination } from 'bootstrap-vue';
import { BButton } from 'bootstrap-vue';
import { BNavbar } from 'bootstrap-vue';
import { BNavbarNav } from 'bootstrap-vue';
import { BNavbarBrand } from 'bootstrap-vue';
import { BNavbarToggle } from 'bootstrap-vue';
import { BNavItem } from 'bootstrap-vue';
import { BNavItemDropdown } from 'bootstrap-vue';
import { BCollapse } from 'bootstrap-vue';
import { BBadge } from 'bootstrap-vue';
import { BDropdown } from 'bootstrap-vue';
import { BDropdownItem } from 'bootstrap-vue';
import { BLink } from 'bootstrap-vue';
import { BAlert } from 'bootstrap-vue';
import { BModal } from 'bootstrap-vue';

export function initBootstrapVue(vue) {
  vue.component('b-badge', BBadge);
  vue.component('b-dropdown', BDropdown);
  vue.component('b-dropdown-item', BDropdownItem);
  vue.component('b-link', BLink);
  vue.component('b-alert', BAlert);
  vue.component('b-modal', BModal);
  vue.component('b-button', BButton);
  vue.component('b-navbar', BNavbar);
  vue.component('b-navbar-nav', BNavbarNav);
  vue.component('b-navbar-brand', BNavbarBrand);
  vue.component('b-navbar-toggle', BNavbarToggle);
  vue.component('b-pagination', BPagination);
  vue.component('b-progress', BProgress);
  vue.component('b-progress-bar', BProgressBar);
  vue.component('b-form', BForm);
  vue.component('b-form-input', BFormInput);
  vue.component('b-form-group', BFormGroup);
  vue.component('b-form-checkbox', BFormCheckbox);
  vue.component('b-collapse', BCollapse);
  vue.component('b-nav-item', BNavItem);
  vue.component('b-nav-item-dropdown', BNavItemDropdown);
  vue.directive('b-modal', BModal);
}
