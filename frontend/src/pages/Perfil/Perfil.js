/* eslint-disable react/jsx-one-expression-per-line */
import { useAuth0 } from '@auth0/auth0-react';
import { useEffect, useState } from 'react';

function Perfil() {
  // eslint-disable-next-line operator-linebreak
  const { user, isAuthenticated, isLoading, getAccessTokenSilently } =
    useAuth0();
  const [userMetadata, setUserMetadata] = useState(null);

  // eslint-disable-next-line no-console
  console.log(user);

  useEffect(() => {
    const getUserMetadata = async () => {
      const domain = process.env.REACT_APP_AUTH0_DOMAIN;

      try {
        const accessToken = await getAccessTokenSilently({
          audience: `https://${domain}/api/v2/`,
          scope: 'read:current_user',
        });
        // eslint-disable-next-line no-console
        console.log('accessToken', accessToken);

        const userDetailsByIdUrl = `https://${domain}/api/v2/users/${user?.sub}`;

        const metadataResponse = await fetch(userDetailsByIdUrl, {
          headers: {
            Authorization: `Bearer ${accessToken}`,
          },
        });
        // eslint-disable-next-line camelcase
        const { user_metadata } = await metadataResponse.json();

        setUserMetadata(user_metadata);
      } catch (e) {
        // eslint-disable-next-line no-console
        console.log(e.message);
      }
    };

    getUserMetadata();
  }, [getAccessTokenSilently, user?.sub]);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    isAuthenticated && (
      <div>
        <img src={user.picture} alt={user.name} />
        <h2>{user.name}</h2>
        <p>El mail es: {user.email}</p>
        <pre>{JSON.stringify(user, null, 2)}</pre>
        <h3>User Metadata</h3>
        {userMetadata ? (
          <pre>{JSON.stringify(userMetadata, null, 2)}</pre>
        ) : (
          'No user metadata defined'
        )}
      </div>
    )
  );
}

export default Perfil;
