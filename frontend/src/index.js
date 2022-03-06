/* eslint-disable no-unused-vars */
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { Auth0Provider, Auth0Context, useAuth0 } from '@auth0/auth0-react';

import App from './App';
import store from './store/store';

import './index.css';

ReactDOM.render(
  <Auth0Provider
    domain={process.env.REACT_APP_AUTH0_DOMAIN}
    clientId={process.env.REACT_APP_AUTH0_CLIENT_ID}
    redirectUri={window.location.origin}
  >
    <Auth0Context.Consumer>
      {({ getAccessTokenSilently }) => {
        // eslint-disable-next-line no-console
        /*
        try {
          await getAccessTokenSilently();
        } catch (e) {
          if (e.error === 'login_required') {
            // loginWithRedirect();
            // eslint-disable-next-line no-console
            console.log('login with redirect');
          }
          if (e.error === 'consent_required') {
            // loginWithRedirect();
            // eslint-disable-next-line no-console
            console.log('login with redirect');
          }
          // throw e;
          // eslint-disable-next-line no-console
          console.log(e);
        }
*/
        return (
          <Provider store={store}>
            <App />
          </Provider>
        );
      }}
    </Auth0Context.Consumer>
  </Auth0Provider>,
  document.getElementById('root'),
);
